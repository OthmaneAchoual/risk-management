package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
