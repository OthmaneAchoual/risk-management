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

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.services.ChoiceService;

@RestController
@RequestMapping("/api/choice")
@CrossOrigin(origins="http://localhost:4200")
public class ChoiceController {

	@Autowired
	private ChoiceService service;
	
	@GetMapping("")
	public List<Choice> all() {
		return this.service.all();
	}
	
	@GetMapping("/{id}")
	public Choice get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@PostMapping("")
	public Choice add(@RequestBody Choice choice) {
		return this.service.add(choice);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}
}
