package be.issep.riskmanagement.api.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import be.issep.riskmanagement.api.entities.Equipment;
import be.issep.riskmanagement.api.entities.dtos.EquipmentDTO;
import be.issep.riskmanagement.api.services.EquipmentService;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin(origins="http://localhost:4200")
public class EquipmentController {

	@Autowired
	private EquipmentService service;
	
	@GetMapping("")
	public List<Equipment> all() {
		return this.service.all();
	}
	
	@PostMapping("")
	public Equipment add(@RequestBody EquipmentDTO equipment) {
		return this.service.add(equipment);
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file) {
		return this.service.saveImage(file);
	}
	
	@GetMapping("/{id}/download")
	public ResponseEntity<Resource> download(@PathVariable("id") Long id) {
		Equipment e = this.service.get(id);
		Path path = Paths.get(e.getImagePath());
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
