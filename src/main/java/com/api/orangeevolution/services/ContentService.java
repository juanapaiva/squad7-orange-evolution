package com.api.orangeevolution.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.orangeevolution.entities.Content;
import com.api.orangeevolution.repositories.ContentRepository;
import com.api.orangeevolution.services.exceptions.DatabaseException;
import com.api.orangeevolution.services.exceptions.ResourceNotFoundException;

@Service
public class ContentService {

	@Autowired
	private ContentRepository repo;
	
	public Content create(Content content) {
		return repo.save(content);
	}

	public List<Content> readAll() {
		return repo.findAll();
	}
	
	public Content readById(Integer id) {
		Optional<Content> content = repo.findById(id);
		return content.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Content update(Integer id, Content newContent) {
		try {
			Content content = repo.getReferenceById(id);
			updateData(content, newContent);
			return repo.save(newContent);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Content content, Content newContent) {
		content.setCategory(newContent.getCategory());
		content.setSubject(newContent.getSubject());
		content.setTitle(newContent.getTitle());
		content.setType(newContent.getType());
		content.setOwner(newContent.getOwner());
		content.setDuration(newContent.getDuration());
		content.setLink(newContent.getLink());
	}
	
	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
