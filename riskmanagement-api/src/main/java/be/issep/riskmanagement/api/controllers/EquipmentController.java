package be.issep.riskmanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.issep.riskmanagement.api.entities.Equipment;
import be.issep.riskmanagement.api.entities.dtos.EquipmentDTO;
import be.issep.riskmanagement.api.services.EquipmentService;

@RestController
@RequestMapping("/equipments")
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
}
