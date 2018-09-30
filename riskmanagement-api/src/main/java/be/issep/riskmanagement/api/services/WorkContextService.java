package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Choice;
import be.issep.riskmanagement.api.entities.Document;
import be.issep.riskmanagement.api.entities.Equipment;
import be.issep.riskmanagement.api.entities.Location;
import be.issep.riskmanagement.api.entities.Risk;
import be.issep.riskmanagement.api.entities.User;
import be.issep.riskmanagement.api.entities.WorkContext;
import be.issep.riskmanagement.api.entities.dtos.WorkContextDTO;
import be.issep.riskmanagement.api.repositories.ChoiceRepository;
import be.issep.riskmanagement.api.repositories.DocumentRepository;
import be.issep.riskmanagement.api.repositories.EquipmentRepository;
import be.issep.riskmanagement.api.repositories.LocationRepository;
import be.issep.riskmanagement.api.repositories.RiskRepository;
import be.issep.riskmanagement.api.repositories.UserRepository;
import be.issep.riskmanagement.api.repositories.WorkContextRepository;

@Service
public class WorkContextService {

	@Autowired
	private WorkContextRepository repository;
	
	@Autowired
  private ChoiceRepository choiceRepository;

  @Autowired
  private DocumentRepository documentRepository;
  
  @Autowired
  private RiskRepository riskRepository;
  
  @Autowired
  private LocationRepository locationRepository;
  
  @Autowired
  private EquipmentRepository equipmentRepository;
  
  @Autowired
	private UserRepository userRepository;
	
	public List<WorkContext> all() {
		return this.repository.findAll();
	}
	
	public WorkContext add(WorkContextDTO dto) {
    List<Choice> types         = this.choiceRepository.findAllById(dto.getTypes());
    List<Document> documents   = this.documentRepository.findAllById(dto.getDocuments());
    List<Risk> risks           = this.riskRepository.findAllById(dto.getRisks());
    List<Equipment> equipments = this.equipmentRepository.findAllById(dto.getEquipments());
    List<Location> locations   = this.locationRepository.findAllById(dto.getLocations());
    List<User> users           = this.userRepository.findAllById(dto.getUsers());
		WorkContext entity = dto.convert();
    entity.setTypes(types);
    entity.setDocuments(documents);
    entity.setRisks(risks);
    entity.setEquipments(equipments);
    entity.setLocations(locations);
    entity.setUsers(users);
		return this.repository.save(entity);
	}
}
