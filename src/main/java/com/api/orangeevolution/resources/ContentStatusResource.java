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

import com.api.orangeevolution.entities.ContentStatus;
import com.api.orangeevolution.services.ContentStatusService;

@RestController
@RequestMapping(value = "/status")
public class ContentStatusResource {
	
	@Autowired
	private ContentStatusService service;

	@PostMapping public ResponseEntity<ContentStatus> insert(@RequestBody
	ContentStatus contentStatus) { 
		contentStatus = service.create(contentStatus);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(contentStatus.getId()).toUri(); 
		return ResponseEntity.created(uri).body(contentStatus); 
	}
	
	@GetMapping
	public ResponseEntity<List<ContentStatus>> findAll() {
		List<ContentStatus> allContentStatus = service.readAll();
		return ResponseEntity.ok().body(allContentStatus);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ContentStatus> findById(@PathVariable Integer id) {
		ContentStatus contentStatus = service.readById(id);
		return ResponseEntity.ok().body(contentStatus);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ContentStatus> update(@PathVariable Integer id, @RequestBody ContentStatus contentStatus) {
		contentStatus = service.update(id, contentStatus);
		return ResponseEntity.ok().body(contentStatus);
	}
	
	@DeleteMapping(value = "/{id}") public ResponseEntity<Void>
	delete(@PathVariable Integer id) { 
		service.delete(id); 
		return ResponseEntity.noContent().build(); 
	}
}
