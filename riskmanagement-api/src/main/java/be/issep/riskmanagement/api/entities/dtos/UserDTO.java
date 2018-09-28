package be.issep.riskmanagement.api.entities.dtos;

import be.issep.riskmanagement.api.entities.User;

public class UserDTO {
	
	private String code;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private Long manager;

	public UserDTO() {
		
	}
	
	public UserDTO(String code, String firstname, String lastname, String email, String phone, Long manager) {
		this.code = code;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.manager = manager;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getManager() {
		return manager;
	}

	public void setManager(Long manager) {
		this.manager = manager;
	}
	
	public User convert() {
		return new User(this.code, this.firstname, this.lastname, this.email, this.phone);
	}
}
