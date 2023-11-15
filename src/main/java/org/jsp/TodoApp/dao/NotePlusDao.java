package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.NotePlus;
import org.jsp.TodoApp.repository.NotePlusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NotePlusDao {
	@Autowired
	private NotePlusRepository repository;
	
	public NotePlus saveNotePlus(NotePlus noteplus) {
		System.out.println(repository);
		return repository.save(noteplus);		
	}
	
	public NotePlus updateNotePlus(NotePlus noteplus) {
		return repository.save(noteplus);
	}
	
	public Optional<NotePlus> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<NotePlus> recNotePlus = findById(id);
		if (recNotePlus.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<NotePlus> getAllNotePlus() {
		return repository.findAll();
	}
}
