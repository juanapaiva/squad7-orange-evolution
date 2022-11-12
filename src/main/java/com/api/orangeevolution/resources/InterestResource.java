package com.api.orangeevolution.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.orangeevolution.entities.Interest;
import com.api.orangeevolution.services.InterestService;

@RestController
@RequestMapping(value = "/interests")
public class InterestResource {
	
	@Autowired
	private InterestService service;

	@PostMapping
	public ResponseEntity<Interest> insert(@RequestBody Interest interest) {
		interest = service.create(interest);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(interest.getId()).toUri();
		return ResponseEntity.created(uri).body(interest);
	}
	
	@GetMapping
	public ResponseEntity<List<Interest>> findAll() {
		List<Interest> interests = service.readAll();
		return ResponseEntity.ok().body(interests);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Interest> findById(@PathVariable Integer id) {
		Interest interest = service.readById(id);
		return ResponseEntity.ok().body(interest);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Interest> update(@PathVariable Integer id, @RequestBody Interest interest) {
		interest = service.update(id, interest);
		return ResponseEntity.ok().body(interest);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
