package be.issep.riskmanagement.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.issep.riskmanagement.api.entities.Location;
import be.issep.riskmanagement.api.entities.dtos.LocationDTO;
import be.issep.riskmanagement.api.services.LocationService;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
public class LocationController {

	@Autowired
	private LocationService service;
	
	@GetMapping("")
	public List<Location> all() {
		return this.service.all();
	}
	
	@PostMapping("")
	public Location add(@RequestBody LocationDTO loc) {
		return this.service.addLocation(loc);
	}
	
	@PutMapping("/{id}")
	public Location update(@PathVariable("id") Long id, @RequestBody LocationDTO loc) {
		return this.service.updateLocation(loc, id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.deleteLocation(id);
	}
}
