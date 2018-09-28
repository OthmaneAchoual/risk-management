package be.issep.riskmanagement.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.issep.riskmanagement.api.entities.Location;
import be.issep.riskmanagement.api.entities.dtos.LocationDTO;
import be.issep.riskmanagement.api.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository repository;
	
	public List<Location> all() {
		return this.repository.findAll();
	}
	
	public Location addLocation(LocationDTO loc) {
		Location root = null;
		if (loc.getRoot() != null) {
			root = this.repository.findById(loc.getRoot()).get();
		}
		Location entity = loc.convert();
		entity.setRoot(root);
		return this.repository.save(entity);
	}
	
	public Location updateLocation(LocationDTO dto, Long id) {
		Location loc = dto.convert();
		loc.setId(id);
		return this.repository.save(loc);
	}
	
	public void deleteLocation(Long id) {
		this.repository.deleteById(id);
	}
}
