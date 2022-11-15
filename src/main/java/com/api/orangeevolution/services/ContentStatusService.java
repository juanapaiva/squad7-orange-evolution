package com.api.orangeevolution.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.orangeevolution.entities.ContentStatus;
import com.api.orangeevolution.repositories.ContentStatusRepository;
import com.api.orangeevolution.services.exceptions.DatabaseException;
import com.api.orangeevolution.services.exceptions.ResourceNotFoundException;

@Service
public class ContentStatusService {

	@Autowired
	private ContentStatusRepository repo;
	
	/*
	 * public ContentStatus create(ContentStatus contentStatus) { return
	 * repo.save(contentStatus); }
	 */

	public List<ContentStatus> readAll() {
		return repo.findAll();
	}
	
	public ContentStatus readById(Integer id) {
		Optional<ContentStatus> contentStatus = repo.findById(id);
		return contentStatus.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ContentStatus update(Integer id, ContentStatus newContentStatus) {
		try {
			ContentStatus contentStatus = repo.getReferenceById(id);
			updateData(contentStatus, newContentStatus);
			return repo.save(newContentStatus);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(ContentStatus contentStatus, ContentStatus newContentStatus) {
		contentStatus.setContentStatus(newContentStatus.getStatus());
	}
	
	/*
	 * public void delete(Integer id) { try { repo.deleteById(id); } catch
	 * (EmptyResultDataAccessException e) { throw new ResourceNotFoundException(id);
	 * } catch (DataIntegrityViolationException e) { throw new
	 * DatabaseException(e.getMessage()); } }
	 */
}
