package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
