package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Quick;
import org.jsp.TodoApp.repository.QuickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuickDao {
	@Autowired
	private QuickRepository repository;
	
	public Quick saveQuick(Quick quick) {
		System.out.println(repository);
		return repository.save(quick);		
	}
	
	public Quick updateQuick(Quick quick) {
		return repository.save(quick);
	}
	
	public Optional<Quick> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Quick> recQuick= findById(id);
		if (recQuick.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Quick> getAllQuick() {
		return repository.findAll();
	}
}
