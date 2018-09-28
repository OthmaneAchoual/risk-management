package be.issep.riskmanagement.api.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public String saveImage(MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			BufferedOutputStream os = new BufferedOutputStream(
						new FileOutputStream(new File("/Users/othmaneachoual/git/risk-management/" + file.getOriginalFilename()))
					);
			os.write(bytes);
			os.close();
		} catch (Exception e) {
			
		}
		return "/Users/othmaneachoual/git/risk-management/" + file.getOriginalFilename();
	}
}