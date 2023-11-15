package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.EssayDao;
import org.jsp.TodoApp.dto.Essay;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EssayService {
	@Autowired
	private EssayDao dao;
	
	public ResponseEntity<ResponseStructure<Essay>> saveEssay(Essay essay) {
		ResponseStructure<Essay> structure = new ResponseStructure<>();
		essay = dao.saveEssay(essay);
		structure.setData(essay);
		structure.setMessage("Message registered successfully"+ essay.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Essay>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Essay>> updateEssay(Essay essay) {
		ResponseStructure<Essay> structure = new ResponseStructure<>();
		essay = dao.updateEssay(essay);
		structure.setData(essay);
		structure.setMessage("Message updateded successfully"+ essay.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Essay>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Essay>> findById(int id) {
		Optional<Essay> recEssay = dao.findById(id);
		ResponseStructure<Essay> structure=new ResponseStructure<>();
		if (recEssay.isPresent()) 
		{
			structure.setData(recEssay.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Essay>>(structure, HttpStatus.OK);
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
	
	public List<Essay> getAllEssay() {
		return dao.getAllEssay();
	}
}
