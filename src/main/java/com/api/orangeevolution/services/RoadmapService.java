package com.api.orangeevolution.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.orangeevolution.entities.Roadmap;
import com.api.orangeevolution.repositories.RoadmapRepository;
import com.api.orangeevolution.services.exceptions.DatabaseException;
import com.api.orangeevolution.services.exceptions.ResourceNotFoundException;

@Service
public class RoadmapService {

	@Autowired
	private RoadmapRepository repo;
	
	public Roadmap create(Roadmap roadmap) {
		return repo.save(roadmap);
	}

	public List<Roadmap> readAll() {
		return repo.findAll();
	}
	
	public Roadmap readById(Integer id) {
		Optional<Roadmap> roadmap = repo.findById(id);
		return roadmap.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Roadmap update(Integer id, Roadmap newRoadmap) {
		try {
			Roadmap roadmap = repo.getReferenceById(id);
			updateData(roadmap, newRoadmap);
			return repo.save(newRoadmap);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(Roadmap roadmap, Roadmap newRoadmap) {
		roadmap.setTitle(newRoadmap.getTitle());
		roadmap.setDuration(newRoadmap.getDuration());
		roadmap.setCreator(newRoadmap.getCreator());
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
