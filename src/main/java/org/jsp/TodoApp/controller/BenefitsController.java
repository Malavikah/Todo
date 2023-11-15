package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Benefits;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.BenefitsService;
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
public class BenefitsController {
	@Autowired
	private BenefitsService service;
	
	@PostMapping("/benefit")
	public ResponseEntity<ResponseStructure<Benefits>> saveBenefit(@RequestBody Benefits benefit){
		return service.saveBenefits(benefit);
	}
	
	@PutMapping("/benefit/{id}")
	public ResponseEntity<ResponseStructure<Benefits>> updateBenefit(@RequestBody Benefits benefit, @PathVariable int id){
		return service.updateBenefits(benefit);
	}
	
	@GetMapping("/benefit/{id}")
	public ResponseEntity<ResponseStructure<Benefits>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/benefit/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/benefit")
	public List<Benefits> getAllBenefit(){
		return service.getAllBenefit();
	}
	
}
