package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.BirthdayDao;
import org.jsp.TodoApp.dto.Birthday;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BirthdayService {
	@Autowired
	private BirthdayDao dao;
	
	public ResponseEntity<ResponseStructure<Birthday>> saveBirthday(Birthday birthday) {
		ResponseStructure<Birthday> structure = new ResponseStructure<>();
		birthday = dao.saveBirthday(birthday);
		structure.setData(birthday);
		structure.setMessage("Message registered successfully"+ birthday.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Birthday>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Birthday>> updateBirthday(Birthday birthday) {
		ResponseStructure<Birthday> structure = new ResponseStructure<>();
		birthday = dao.updateBirthday(birthday);
		structure.setData(birthday);
		structure.setMessage("Message updateded successfully"+ birthday.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Birthday>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Birthday>> findById(int id) {
		Optional<Birthday> recBirthday = dao.findById(id);
		ResponseStructure<Birthday> structure=new ResponseStructure<>();
		if (recBirthday.isPresent()) 
		{
			structure.setData(recBirthday.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Birthday>>(structure, HttpStatus.OK);
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
	
	public List<Birthday> getAllBirthday() {
		return dao.getAllBirthday();
	}
}
