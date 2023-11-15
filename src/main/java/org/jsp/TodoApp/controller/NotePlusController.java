package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.NotePlus;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.NotePlusService;
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

public class NotePlusController {
	@Autowired
	private NotePlusService service;
	
	@PostMapping("/noteplus")
	public ResponseEntity<ResponseStructure<NotePlus>> saveNotePlus(@RequestBody NotePlus noteplus){
		return service.saveNotePlus(noteplus);
	}
	
	@PutMapping("/noteplus/{id}")
	public ResponseEntity<ResponseStructure<NotePlus>> updateNotePlus(@RequestBody NotePlus noteplus, @PathVariable int id){
		return service.updateNotePlus(noteplus);
	}
	
	@GetMapping("/noteplus/{id}")
	public ResponseEntity<ResponseStructure<NotePlus>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/noteplus/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	@GetMapping("/noteplus")
	public List<NotePlus> getAllNotePlus(){
		return service.getAllNotePlus();
	}
}
