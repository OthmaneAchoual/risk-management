package be.issep.riskmanagement.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("ID")
	private Long id;
	
	private String code;
	private String title;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="ROOT")
	@JsonIgnoreProperties("root")
	private Location root;
	
	public Location() {}

	public Location(String code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Location getRoot() {
		return root;
	}

	public void setRoot(Location root) {
		this.root = root;
	}
	
}
