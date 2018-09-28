package be.issep.riskmanagement.api.entities.dtos;

import be.issep.riskmanagement.api.entities.Equipment;

public class EquipmentDTO {

	private String title;
	private String code;
	private String description;
	private Long type;
	private String imagePath;
	private boolean epc;
	private boolean training;
	
	public EquipmentDTO() {}

	public EquipmentDTO(String title, String code, String description, Long type, String imagePath, boolean epc, boolean training) {
		this.title = title;
		this.code = code;
		this.description = description;
		this.type = type;
		this.imagePath = imagePath;
		this.epc = epc;
		this.training = training;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEpc() {
		return epc;
	}

	public void setEpc(boolean epc) {
		this.epc = epc;
	}

	public boolean isTraining() {
		return training;
	}

	public void setTraining(boolean training) {
		this.training = training;
	}
	
	public Equipment convert() {
		return new Equipment(
				this.title,
				this.code,
				this.description,
				this.imagePath,
				this.epc,
				this.training
		);
	}
}
