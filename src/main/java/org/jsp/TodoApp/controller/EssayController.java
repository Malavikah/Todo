package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Essay;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.EssayService;
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
public class EssayController {
	@Autowired
	private EssayService service;
	
	@PostMapping("/essay")
	public ResponseEntity<ResponseStructure<Essay>> saveEssay(@RequestBody Essay essay){
		return service.saveEssay(essay);
	}
	
	@PutMapping("/essay/{id}")
	public ResponseEntity<ResponseStructure<Essay>> updateEssay(@RequestBody Essay essay, @PathVariable int id){
		return service.updateEssay(essay);
	}
	
	@GetMapping("/essay/{id}")
	public ResponseEntity<ResponseStructure<Essay>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/essay/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/essay")
	public List<Essay> getAllEssay(){
		return service.getAllEssay();
	}
}

