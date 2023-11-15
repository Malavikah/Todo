package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.WeeklyPlannerDao;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.dto.WeeklyPlanner;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeeklyPlannerService {
	@Autowired
	private WeeklyPlannerDao dao;
	
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> saveWeeklyPlanner(WeeklyPlanner weekly) {
		ResponseStructure<WeeklyPlanner> structure=new ResponseStructure<>();
		weekly = dao.saveWeeklyPlanner(weekly);
		structure.setData(weekly);
		structure.setMessage("Message registered successfully"+weekly.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<WeeklyPlanner>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> updateWeeklyPlanner(WeeklyPlanner weekly){
		ResponseStructure<WeeklyPlanner> structure = new ResponseStructure<>();
		weekly = dao.updateWeeklyPlanner(weekly);
		structure.setData(weekly);
		structure.setMessage("Message updated successfully"+ weekly.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<WeeklyPlanner>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<WeeklyPlanner>> findById(int id) {
		Optional<WeeklyPlanner> recWeekly = dao.findById(id);
		ResponseStructure<WeeklyPlanner> structure=new ResponseStructure<>();
		if (recWeekly.isPresent()) 
		{
			structure.setData(recWeekly.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<WeeklyPlanner>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		boolean deleted = dao.deleteById(id);
		ResponseStructure<String> structure=new ResponseStructure<>();
		if(deleted) {
			structure.setData("Deleted");
			structure.setMessage("Not Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData(" Deleted");
		structure.setMessage("Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	public List<WeeklyPlanner> getAllWeekly() {
		return dao.getAllWeekly();
	}
	
}