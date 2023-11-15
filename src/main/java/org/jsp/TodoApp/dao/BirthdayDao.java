package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Birthday;
import org.jsp.TodoApp.repository.BirthdayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BirthdayDao {
	@Autowired
	private BirthdayRepository repository;
	
	public Birthday saveBirthday(Birthday birthday) {
		System.out.println(repository);
		return repository.save(birthday);		
	}
	
	public Birthday updateBirthday(Birthday birthday) {
		return repository.save(birthday);
	}
	
	public Optional<Birthday> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Birthday> recBirthday = findById(id);
		if (recBirthday.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Birthday> getAllBirthday() {
		return repository.findAll();
	}
	
}