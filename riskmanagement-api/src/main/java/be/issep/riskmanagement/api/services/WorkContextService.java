package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.WorkContext;
import be.issep.riskmanagement.api.entities.dtos.WorkContextDTO;
import be.issep.riskmanagement.api.repositories.ChoiceRepository;
import be.issep.riskmanagement.api.repositories.WorkContextRepository;

@Service
public class WorkContextService {

	@Autowired
	private WorkContextRepository repository;
	
	@Autowired
	private ChoiceRepository choiceRepository;
	
	public List<WorkContext> all() {
		return this.repository.findAll();
	}
	
	public WorkContext add(WorkContextDTO ctx) {
		List<Choice> types = this.choiceRepository.findAllById(ctx.getTypes());
		WorkContext entity = ctx.convert();
		entity.setTypes(types);
		return this.repository.save(entity);
	}
}
