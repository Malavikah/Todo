package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.WeeklyPlanner;
import org.jsp.TodoApp.repository.WeeklyPlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WeeklyPlannerDao {
	@Autowired
	private WeeklyPlannerRepository repository;
	
	public WeeklyPlanner saveWeeklyPlanner(WeeklyPlanner weekly) {
		System.out.println(repository);
		return repository.save(weekly);		
	}
	
	public WeeklyPlanner updateWeeklyPlanner(WeeklyPlanner weekly) {
		return repository.save(weekly);
	}
	
	public Optional<WeeklyPlanner> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<WeeklyPlanner> recWeekly = findById(id);
		if (recWeekly.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<WeeklyPlanner> getAllWeekly() {
		return repository.findAll();
	}
	
}
