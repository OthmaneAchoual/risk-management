package be.issep.riskmanagement.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Equipment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("ID")
	private Long id;
	private String title;
	private String code;
	private String description;
	private boolean isEPC;
	private boolean training;
	
	@ManyToOne
	@JoinColumn(name="TYPE")
	private Choice type;
	
	public Equipment() {}

	public Equipment(String title, String code, String description, boolean isEPC, boolean training) {
		this.title = title;
		this.code = code;
		this.description = description;
		this.isEPC = isEPC;
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public boolean isEPC() {
		return isEPC;
	}

	public void setEPC(boolean isEPC) {
		this.isEPC = isEPC;
	}

	public boolean isTraining() {
		return training;
	}

	public void setTraining(boolean training) {
		this.training = training;
	}

	public Choice getType() {
		return type;
	}

	public void setType(Choice type) {
		this.type = type;
	}
	
	
}
