package be.issep.riskmanagement.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Risk {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("ID")
	private Long id;
	
	private String reference;
	private String title;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="TYPE")
	private Choice type;
	
	@ManyToOne
	@JoinColumn(name="ROOT")
	private Risk root;
	
	public Risk() {}

	public Risk(String reference, String title, String description) {
		this.reference = reference;
		this.title = title;
		this.description = description;
	}

	public Choice getType() {
		return type;
	}

	public void setType(Choice type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Risk getRoot() {
		return root;
	}

	public void setRoot(Risk root) {
		this.root = root;
	}
	
	
}
