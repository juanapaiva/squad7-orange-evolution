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

import com.api.orangeevolution.entities.Roadmap;
import com.api.orangeevolution.services.RoadmapService;

@RestController
@RequestMapping(value = "/roadmaps")
public class RoadmapResource {
	
	@Autowired
	private RoadmapService service;

	@PostMapping
	public ResponseEntity<Roadmap> insert(@RequestBody Roadmap roadmap) {
		roadmap = service.create(roadmap);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(roadmap.getId()).toUri();
		return ResponseEntity.created(uri).body(roadmap);
	}
	
	@GetMapping
	public ResponseEntity<List<Roadmap>> findAll() {
		List<Roadmap> roadmaps = service.readAll();
		return ResponseEntity.ok().body(roadmaps);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Roadmap> findById(@PathVariable Integer id) {
		Roadmap roadmap = service.readById(id);
		return ResponseEntity.ok().body(roadmap);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Roadmap> update(@PathVariable Integer id, @RequestBody Roadmap roadmap) {
		roadmap = service.update(id, roadmap);
		return ResponseEntity.ok().body(roadmap);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
