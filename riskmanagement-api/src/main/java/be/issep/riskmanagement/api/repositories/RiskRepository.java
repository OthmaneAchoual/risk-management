package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.Risk;

public interface RiskRepository extends JpaRepository<Risk, Long> {

}
