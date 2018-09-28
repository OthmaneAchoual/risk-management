package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {

}
