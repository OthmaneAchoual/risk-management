package be.issep.riskmanagement.api.entities.dtos;

import be.issep.riskmanagement.api.entities.Document;

public class DocumentDTO {

	private String code;
	private String title;
	private String filePath;
	private Long category;
	
	public DocumentDTO() {
		
	}
	
	public DocumentDTO(String code, String title, Long category) {
		this.code = code;
		this.title = title;
		this.category = category;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Document convert() {
		return new Document(
				this.code,
				this.title,
				this.filePath
		);
	}
}
