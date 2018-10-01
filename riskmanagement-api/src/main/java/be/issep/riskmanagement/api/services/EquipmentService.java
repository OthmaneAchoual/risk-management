package be.issep.riskmanagement.api.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
  
  @Value("${image.directory}")
  private String directory;
	
	public List<Equipment> all() {
		return this.repository.findAll();
	}
	
	public Equipment get(Long id) {
		return this.repository.findById(id).get();
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
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
	
	public Equipment update(EquipmentDTO equipment, Long id) {
		Choice type = this.choiceService.get(equipment.getType());
		Equipment entity = this.repository.findById(id).get();
		entity.setCode(equipment.getCode());
		entity.setTitle(equipment.getTitle());
		entity.setEpc(equipment.isEpc());
		entity.setTraining(equipment.isTraining());
		entity.setImagePath(equipment.getImagePath());
		entity.setType(type);
		return this.repository.save(entity);
	}
	
	public String saveImage(MultipartFile file) {
		String path = this.directory + file.getOriginalFilename();
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream os = new BufferedOutputStream(
						new FileOutputStream(new File(path))
					);
			os.write(bytes);
			os.close();
		} catch (Exception e) {
			
		}
		return path;
	}
}
