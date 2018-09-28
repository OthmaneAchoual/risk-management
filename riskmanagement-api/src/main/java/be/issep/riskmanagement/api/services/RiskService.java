package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Risk;
import be.issep.riskmanagement.api.entities.dtos.RiskDTO;
import be.issep.riskmanagement.api.repositories.RiskRepository;

@Service
public class RiskService {

	@Autowired
	private RiskRepository repository;
	@Autowired
	private ChoiceService choiceService;
	
	public Risk get(Long id) {
		return this.repository.findById(id).get();
	}
	
	public List<Risk> all() {
		return this.repository.findAll();
	}
	
	public Risk add(RiskDTO risk) {
		Risk root = null;
		Choice type = null;
		if (risk.getRoot() != null) {
			root = this.repository.findById(risk.getRoot()).get();
		}
		if (risk.getType() != null) {
			type = this.choiceService.get(risk.getType());
		}
		Risk entity = risk.convert();
		entity.setRoot(root);
		entity.setType(type);
		return this.repository.save(entity); 
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
