package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Equipment;
import be.issep.riskmanagement.api.entities.dtos.EquipmentDTO;
import be.issep.riskmanagement.api.repositories.EquipmentRepository;

@Service
public class EquipmentService {

	@Autowired
	private EquipmentRepository repository;
	
	@Autowired
	private ChoiceService choiceService;
	
	public List<Equipment> all() {
		return this.repository.findAll();
	}
	
	public Equipment add(EquipmentDTO equipment) {
		Choice type = null;
		if (equipment.getType() != null) {
			type = this.choiceService.get(equipment.getType());
		}
		System.out.println(type);
		Equipment entity = equipment.convert();
		entity.setType(type);
		return this.repository.save(entity);
	}
}
