package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.NotePlusDao;
import org.jsp.TodoApp.dto.NotePlus;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotePlusService {
	@Autowired
	private NotePlusDao dao;
	
	public ResponseEntity<ResponseStructure<NotePlus>> saveNotePlus(NotePlus noteplus) {
		ResponseStructure<NotePlus> structure = new ResponseStructure<>();
		noteplus = dao.saveNotePlus(noteplus);
		structure.setData(noteplus);
		structure.setMessage("Message registered successfully"+ noteplus.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<NotePlus>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<NotePlus>> updateNotePlus(NotePlus noteplus) {
		ResponseStructure<NotePlus> structure = new ResponseStructure<>();
		noteplus = dao.updateNotePlus(noteplus);
		structure.setData(noteplus);
		structure.setMessage("Message updateded successfully"+ noteplus.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<NotePlus>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<NotePlus>> findById(int id) {
		Optional<NotePlus> recNotePlus = dao.findById(id);
		ResponseStructure<NotePlus> structure=new ResponseStructure<>();
		if (recNotePlus.isPresent()) 
		{
			structure.setData(recNotePlus.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<NotePlus>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		boolean deleted = dao.deleteById(id);
		ResponseStructure<String> structure=new ResponseStructure<>();
		if(deleted) {
			structure.setData("Deleted");
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData(" Deleted");
		structure.setMessage("Not Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}
	
	public List<NotePlus> getAllNotePlus() {
		return dao.getAllNotePlus();
	}
}
