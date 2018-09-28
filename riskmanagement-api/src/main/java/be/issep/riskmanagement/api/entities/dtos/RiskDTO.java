package be.issep.riskmanagement.api.entities.dtos;

import be.issep.riskmanagement.api.entities.Risk;

public class RiskDTO {

	private String reference;
	private String title;
	private String description;
	private Long root;
	private Long type;

	public RiskDTO() {}
	
	public RiskDTO(String reference, String title, String description, Long root, Long type) {
		this.reference = reference;
		this.title = title;
		this.description = description;
		this.root = root;
		this.type = type;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public Risk convert() {
		return new Risk(
				this.reference,
				this.title,
				this.description
				);
	}
}
