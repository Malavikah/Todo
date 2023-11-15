package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Quick;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.QuickService;
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
public class QuickController {
	@Autowired
	private QuickService service;
	
	@PostMapping("/quick")
	public ResponseEntity<ResponseStructure<Quick>> saveQuick(@RequestBody Quick quick){
		return service.saveQuick(quick);
	}
	
	@PutMapping("/quick/{id}")
	public ResponseEntity<ResponseStructure<Quick>> updateQuick(@RequestBody Quick quick, @PathVariable int id){
		return service.updateQuick(quick);
	}
	
	@GetMapping("/quick/{id}")
	public ResponseEntity<ResponseStructure<Quick>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/quick")
	public List<Quick> getAllQuick(){
		return service.getAllQuick();
	}
	
	@DeleteMapping("/quick/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
}
