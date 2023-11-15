package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Birthday;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.BirthdayService;
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
public class BirthdayController {
	@Autowired
	private BirthdayService service;
	
	@PostMapping("/birthday")
	public ResponseEntity<ResponseStructure<Birthday>> saveBirthday(@RequestBody Birthday birthday){
		return service.saveBirthday(birthday);
	}
	
	@PutMapping("/birthday/{id}")
	public ResponseEntity<ResponseStructure<Birthday>> updateBirthday(@RequestBody Birthday birthday, @PathVariable int id){
		return service.updateBirthday(birthday);
	}
	
	@GetMapping("/birthday/{id}")
	public ResponseEntity<ResponseStructure<Birthday>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/birthday/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/birthday")
	public List<Birthday> getAllBirthday(){
		return service.getAllBirthday();
	}
}
