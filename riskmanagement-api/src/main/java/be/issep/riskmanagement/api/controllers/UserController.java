package be.issep.riskmanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.issep.riskmanagement.api.entities.User;
import be.issep.riskmanagement.api.entities.dtos.UserDTO;
import be.issep.riskmanagement.api.services.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@GetMapping("")
	public List<User> all() {
		return this.service.all();
	}
	
	@PostMapping("")
	public User add(@RequestBody UserDTO user) {
		return this.service.add(user);
  }
  
  @PutMapping("/{id}")
  public User update(@RequestBody UserDTO user, @PathVariable("id") Long id) {
    return this.service.update(user, id);
  }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}
}
