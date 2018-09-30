package be.issep.riskmanagement.api.entities.dtos;

import java.util.List;

import be.issep.riskmanagement.api.entities.WorkContext;

public class WorkContextDTO {

	private String name;
	private String code;
	private String shortDescription;
	private String fullDescription;
	private Long type;
	
	private List<Long> types;
	private List<Long> equipments;
  private List<Long> locations;
  private List<Long> documents;
  private List<Long> risks;
  private List<Long> users;
	
	public WorkContextDTO() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public List<Long> getTypes() {
		return types;
	}

	public void setTypes(List<Long> types) {
		this.types = types;
	}

	public List<Long> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Long> equipments) {
		this.equipments = equipments;
	}

	public List<Long> getLocations() {
		return locations;
	}

	public void setLocations(List<Long> locations) {
		this.locations = locations;
  }
  
  public List<Long> getDocuments() {
    return this.documents;
  }

  public void setDocuments(List<Long> documents) {
    this.documents = documents;
  }

  public List<Long> getRisks() {
    return this.risks;
  }

  public void setRisks(List<Long> risks) {
    this.risks = risks;
  }

  public List<Long> getUsers() {
    return this.users;
  }

  public void setUers(List<Long> users) {
    this.users = users;
  }

	public WorkContext convert() {
		return new WorkContext(this.name, this.code, this.shortDescription, this.fullDescription);
	}
}
