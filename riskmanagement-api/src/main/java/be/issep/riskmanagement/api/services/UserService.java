package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.User;
import be.issep.riskmanagement.api.entities.dtos.UserDTO;
import be.issep.riskmanagement.api.repositories.UserRepository;

@Service
public class UserService implements be.issep.riskmanagement.api.services.Service<User, UserDTO, Long> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id).get();
	}

	@Override
	public List<User> all() {
		// TODO Auto-generated method stub
		return this.repository.findAll();
	}

	@Override
	public User add(UserDTO dto) {
		// TODO Auto-generated method stub
		User manager = null;
		if(dto.getManager() != null) {
			manager = this.repository.findById(dto.getManager()).get();
		}
		User entity = dto.convert();
		entity.setManager(manager);
		return this.repository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		User user = this.repository.findById(id).get();
		this.repository.delete(user);
	}

}
