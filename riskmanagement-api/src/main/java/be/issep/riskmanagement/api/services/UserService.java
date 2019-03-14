package be.issep.riskmanagement.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.User;
import be.issep.riskmanagement.api.entities.dtos.UserDTO;
import be.issep.riskmanagement.api.repositories.UserRepository;

@Service
public class UserService implements be.issep.riskmanagement.api.services.Service<User, UserDTO, Long> {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;
	
	@Override
	public User get(Long id) {
		return this.repository.findById(id).get();
	}

	@Override
	public List<User> all() {
		return this.repository.findAll();
	}

	@Override
	public User add(UserDTO dto) {
		User manager = null;
		if(dto.getManager() != null) {
			manager = this.repository.findById(dto.getManager()).get();
		}
		User entity = dto.convert();
		entity.setManager(manager);
		entity = this.repository.save(entity);
		logger.info("saved new user {} with id {}", entity.getFirstname() + ", " + entity.getLastname(), entity.getId());
		return entity;
	}

  public User update(UserDTO dto, Long id) {
    User user = this.repository.findById(id).get();
    User manager = null;
		if(dto.getManager() != null) {
			manager = this.repository.findById(dto.getManager()).get();
    }
    user.setFirstname(dto.getFirstname());
    user.setLastname(dto.getLastname());
    user.setEmail(dto.getEmail());
    user.setPhone(dto.getPhone());
    user.setManager(manager);
    return this.repository.save(user);
  }

	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
