package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Benefits;
import org.jsp.TodoApp.repository.BenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BenefitsDao {
	@Autowired
	private BenefitsRepository repository;
	
	public Benefits saveBenefits(Benefits benefits) {
		System.out.println(repository);
		return repository.save(benefits);		
	}
	
	public Benefits updateBenefits(Benefits benefits) {
		return repository.save(benefits);
	}
	
	public Optional<Benefits> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Benefits> recBenefits = findById(id);
		if (recBenefits.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Benefits> getAllBenefits() {
		return repository.findAll();
	}
}
