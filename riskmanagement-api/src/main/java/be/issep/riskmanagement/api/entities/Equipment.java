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
	private String imagePath;
	private boolean epc;
	private boolean training;
	
	@ManyToOne
	@JoinColumn(name="TYPE")
	private Choice type;
	
	public Equipment() {}

	public Equipment(String title, String code, String description, String imagePath, boolean epc, boolean training) {
		this.title = title;
		this.code = code;
		this.description = description;
		this.imagePath = imagePath;
		this.epc = epc;
		this.training = training;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Choice getType() {
		return type;
	}

	public void setType(Choice type) {
		this.type = type;
	}
	
	
}
