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

import be.issep.riskmanagement.api.entities.Risk;
import be.issep.riskmanagement.api.entities.dtos.RiskDTO;
import be.issep.riskmanagement.api.services.RiskService;

@RestController
@RequestMapping("/api/risk")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class RiskController {

	@Autowired
	private RiskService service;
	
	@GetMapping("")
	public List<Risk> all() {
		return this.service.all();
	}
	
	@PostMapping
	public Risk add(@RequestBody RiskDTO risk) {
		return this.service.add(risk);
	}
	
	@GetMapping("/{id}")
	public Risk get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}
}
