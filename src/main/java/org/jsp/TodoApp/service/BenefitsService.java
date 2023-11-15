package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.BenefitsDao;
import org.jsp.TodoApp.dto.Benefits;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BenefitsService {
	@Autowired
	private BenefitsDao dao;
	
	public ResponseEntity<ResponseStructure<Benefits>> saveBenefits(Benefits benefits) {
		ResponseStructure<Benefits> structure = new ResponseStructure<>();
		benefits = dao.saveBenefits(benefits);
		structure.setData(benefits);
		structure.setMessage("Message registered successfully"+ benefits.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Benefits>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Benefits>> updateBenefits(Benefits benefits) {
		ResponseStructure<Benefits> structure = new ResponseStructure<>();
		benefits = dao.updateBenefits(benefits);
		structure.setData(benefits);
		structure.setMessage("Message updateded successfully"+ benefits.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Benefits>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Benefits>> findById(int id) {
		Optional<Benefits> recBenefits = dao.findById(id);
		ResponseStructure<Benefits> structure=new ResponseStructure<>();
		if (recBenefits.isPresent()) 
		{
			structure.setData(recBenefits.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Benefits>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
		
	}
	
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
	
	public List<Benefits> getAllBenefit() {
		return dao.getAllBenefits();
	}
}
