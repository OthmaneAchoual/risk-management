package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.WorkContext;

public interface WorkContextRepository extends JpaRepository<WorkContext, Long> {

}
