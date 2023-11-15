package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Essay;
import org.jsp.TodoApp.repository.EssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EssayDao {
	@Autowired
	private EssayRepository repository;
	
	public Essay saveEssay(Essay essay) {
		System.out.println(repository);
		return repository.save(essay);		
	}
	
	public Essay updateEssay(Essay essay) {
		return repository.save(essay);
	}
	
	public Optional<Essay> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Essay> recEssay = findById(id);
		if (recEssay.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Essay> getAllEssay() {
		return repository.findAll();
	}
}
