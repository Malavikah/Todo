package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.QuickDao;
import org.jsp.TodoApp.dto.Quick;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuickService {
	@Autowired
	private QuickDao dao;
	
	public ResponseEntity<ResponseStructure<Quick>> saveQuick(Quick quick) {
		ResponseStructure<Quick> structure = new ResponseStructure<>();
		quick = dao.saveQuick(quick);
		structure.setData(quick);
		structure.setMessage("Message registered successfully"+ quick.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Quick>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Quick>> updateQuick(Quick quick) {
		ResponseStructure<Quick> structure = new ResponseStructure<>();
		quick = dao.updateQuick(quick);
		structure.setData(quick);
		structure.setMessage("Message updateded successfully"+ quick.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Quick>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Quick>> findById(int id) {
		Optional<Quick> recQuick = dao.findById(id);
		ResponseStructure<Quick> structure=new ResponseStructure<>();
		if (recQuick.isPresent()) 
		{
			structure.setData(recQuick.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Quick>>(structure, HttpStatus.OK);
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
	
	public List<Quick> getAllQuick() {
		return dao.getAllQuick();
	}
}
