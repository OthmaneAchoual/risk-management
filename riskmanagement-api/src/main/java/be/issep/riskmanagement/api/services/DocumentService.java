package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Document;
import be.issep.riskmanagement.api.entities.dtos.DocumentDTO;
import be.issep.riskmanagement.api.repositories.DocumentRepository;

@Service
public class DocumentService implements be.issep.riskmanagement.api.services.Service<Document, DocumentDTO, Long> {

	@Autowired
	private DocumentRepository repository;
	@Autowired
	private ChoiceService choiceService;
	
	@Override
	public Document get(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public List<Document> all() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public Document add(DocumentDTO doc) {
		// TODO Auto-generated method stub
		Choice category = null;
		if(doc.getCategory() != null) {
			category = this.choiceService.get(doc.getCategory());
		}
		Document entity = doc.convert();
		entity.setCategory(category);
		return this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
