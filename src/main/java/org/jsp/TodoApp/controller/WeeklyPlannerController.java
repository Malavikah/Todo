package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.ResponseStructure;

import org.jsp.TodoApp.dto.WeeklyPlanner;
import org.jsp.TodoApp.service.WeeklyPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WeeklyPlannerController {
	@Autowired
	private WeeklyPlannerService service;
	
	@PostMapping("/weekly")
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> saveWeeklyPlanner(@RequestBody WeeklyPlanner weekly){
		return service.saveWeeklyPlanner(weekly);
	}
		
	@PutMapping("/weekly/{id}")
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> updateWeeklyPlanner(@RequestBody WeeklyPlanner weekly, @PathVariable int id){
		return service.updateWeeklyPlanner(weekly);
	}
	
	@GetMapping("/weekly/{id}")
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/weekly")
	public List<WeeklyPlanner> getAllWeekly(){
		return service.getAllWeekly();
	}
	
	@DeleteMapping("/weekly/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
