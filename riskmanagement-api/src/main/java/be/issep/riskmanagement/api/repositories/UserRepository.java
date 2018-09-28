package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
