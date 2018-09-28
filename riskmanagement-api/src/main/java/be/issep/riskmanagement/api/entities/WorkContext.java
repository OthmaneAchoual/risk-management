package be.issep.riskmanagement.api.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class WorkContext {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("ID")
	private Long id;
	
	private String name;
	private String code;
	private String shortDescription;
	private String fullDescription;
	
	@ManyToOne
	@JoinColumn(name="TYPE")
	private Choice type;
	
	@ManyToMany
	@JoinTable(name="CTX_CHOICE",
		joinColumns=@JoinColumn(name="CTX_ID"),
		inverseJoinColumns=@JoinColumn(name="CHOICE_ID")
	)
	private List<Choice> types;
	
	@ManyToMany
	@JoinTable(name="CTX_LOCATION",
		joinColumns=@JoinColumn(name="CTX_ID"),
		inverseJoinColumns=@JoinColumn(name="LOCATION_ID")
	)
	private List<Location> locations;
	
	@ManyToMany
	@JoinTable(name="CTX_EQUIPMENT",
		joinColumns=@JoinColumn(name="CTX_ID"),
		inverseJoinColumns=@JoinColumn(name="EQUIPMENT_ID")
	)
	private List<Equipment> equipments;

	public WorkContext() {}

	public WorkContext(String name, String code, String shortDescription, String fullDescription) {
		this.name = name;
		this.code = code;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Choice getType() {
		return type;
	}

	public void setType(Choice type) {
		this.type = type;
	}
	
	public List<Choice> getTypes() {
		return types;
	}

	public void setTypes(List<Choice> types) {
		this.types = types;
	}
}
