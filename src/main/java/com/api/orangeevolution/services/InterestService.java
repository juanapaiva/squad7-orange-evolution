package com.api.orangeevolution.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.orangeevolution.entities.Interest;
import com.api.orangeevolution.repositories.InterestRepository;
import com.api.orangeevolution.services.exceptions.DatabaseException;
import com.api.orangeevolution.services.exceptions.ResourceNotFoundException;

@Service
public class InterestService {

	@Autowired
	private InterestRepository repo;
	
	public Interest create(Interest interest) {
		return repo.save(interest);
	}

	public List<Interest> readAll() {
		return repo.findAll();
	}
	
	public Interest readById(Integer id) {
		Optional<Interest> interest = repo.findById(id);
		return interest.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Interest update(Integer id, Interest newInterest) {
		try {
			Interest interest = repo.getReferenceById(id);
			updateData(interest, newInterest);
			return repo.save(newInterest);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Interest interest, Interest newInterest) {
		interest.setStack(newInterest.getStack());
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
