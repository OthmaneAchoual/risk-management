package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.repositories.ChoiceRepository;

@Service
public class ChoiceService {

	@Autowired
	private ChoiceRepository repository;
	
	public List<Choice> all() {
		return this.repository.findAll();
	}
	
	public Choice get(Long id) {
		return this.repository.findById(id).get();
	}
	
	public Choice add(Choice choice) {
		return this.repository.save(choice);
	}
	
	public Choice update(Choice choice, Long id) {
		choice.setId(id);
		return this.repository.save(choice);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
