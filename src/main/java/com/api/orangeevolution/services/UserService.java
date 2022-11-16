package com.api.orangeevolution.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.orangeevolution.entities.User;
import com.api.orangeevolution.repositories.UserRepository;
import com.api.orangeevolution.services.exceptions.DatabaseException;
import com.api.orangeevolution.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public User create(User user) {
		return repo.save(user);
	}

	public List<User> readAll() {
		return repo.findAll();
	}
	
	public User readById(Integer id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User update(Integer id, User newUser) {
		try {
			User user = repo.getReferenceById(id);
			updateData(user, newUser);
			return repo.save(newUser);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public void updateData(User user, User newUser) {
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
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
