package be.issep.riskmanagement.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.issep.riskmanagement.api.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
