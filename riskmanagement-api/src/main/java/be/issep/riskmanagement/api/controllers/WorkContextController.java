package be.issep.riskmanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.issep.riskmanagement.api.entities.WorkContext;
import be.issep.riskmanagement.api.entities.dtos.WorkContextDTO;
import be.issep.riskmanagement.api.services.WorkContextService;

@RestController
@RequestMapping("/api/workcontext")
//@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class WorkContextController {

	@Autowired
	private WorkContextService service;
	
	@GetMapping("")
	public List<WorkContext> all() {
		return this.service.all();
	}
	
	@GetMapping("/{id}")
	public WorkContext get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@PostMapping("")
	public WorkContext add(@RequestBody WorkContextDTO ctx) {
		return this.service.add(ctx);
	}
}
