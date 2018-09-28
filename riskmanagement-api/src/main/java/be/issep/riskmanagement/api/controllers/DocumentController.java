package be.issep.riskmanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.issep.riskmanagement.api.entities.Document;
import be.issep.riskmanagement.api.entities.dtos.DocumentDTO;
import be.issep.riskmanagement.api.services.DocumentService;

@RestController
@RequestMapping("/documents")
@CrossOrigin(origins="http://localhost:4200")
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	@GetMapping("/{id}")
	public Document get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@GetMapping("")
	public List<Document> all() {
		return this.service.all();
	}
	
	@PostMapping("")
	public Document add(@RequestBody DocumentDTO doc) {
		return this.service.add(doc);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}
}
