package be.issep.riskmanagement.api.entities.dtos;

import be.issep.riskmanagement.api.entities.Location;

public class LocationDTO {

	private String code;
	private String title;
	private String description;
	private Long root;
	
	public LocationDTO() {}

	public LocationDTO(String code, String title, String description, Long root) {
		this.code = code;
		this.title = title;
		this.description = description;
		this.root = root;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRoot() {
		return root;
	}

	public void setRoot(Long root) {
		this.root = root;
	}
	
	public Location convert() {
		return new Location(
				this.code,
				this.title,
				this.description
		);
	}
}
