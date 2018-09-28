package be.issep.riskmanagement.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String code;
	private String title;
	private String file;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY")
	private Choice category;
	
	public Document() {
		
	}

	public Document(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public Long getId() {
		return id;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Choice getCategory() {
		return category;
	}

	public void setCategory(Choice category) {
		this.category = category;
	}
	
}
