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

import com.api.orangeevolution.entities.Content;
import com.api.orangeevolution.services.ContentService;

@RestController
@RequestMapping(value = "/contents")
public class ContentResource {
	
	@Autowired
	private ContentService service;

	@PostMapping
	public ResponseEntity<Content> insert(@RequestBody Content content) {
		content = service.create(content);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(content.getId()).toUri();
		return ResponseEntity.created(uri).body(content);
	}
	
	@GetMapping
	public ResponseEntity<List<Content>> findAll() {
		List<Content> contents = service.readAll();
		return ResponseEntity.ok().body(contents);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Content> findById(@PathVariable Integer id) {
		Content content = service.readById(id);
		return ResponseEntity.ok().body(content);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Content> update(@PathVariable Integer id, @RequestBody Content content) {
		content = service.update(id, content);
		return ResponseEntity.ok().body(content);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
