package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.LectureDao;
import org.jsp.TodoApp.dto.Lecture;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
	@Autowired
	private LectureDao dao;
	
	public ResponseEntity<ResponseStructure<Lecture>> saveLecture(Lecture lecture) {
		ResponseStructure<Lecture> structure = new ResponseStructure<>();
		lecture = dao.saveLecture(lecture);
		structure.setData(lecture);
		structure.setMessage("Message registered successfully"+ lecture.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Lecture>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Lecture>> updateLecture(Lecture lecture) {
		ResponseStructure<Lecture> structure = new ResponseStructure<>();
		lecture = dao.updateLecture(lecture);
		structure.setData(lecture);
		structure.setMessage("Message updateded successfully"+ lecture.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Lecture>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Lecture>> findById(int id) {
		Optional<Lecture> recLecture = dao.findById(id);
		ResponseStructure<Lecture> structure=new ResponseStructure<>();
		if (recLecture.isPresent()) 
		{
			structure.setData(recLecture.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Lecture>>(structure, HttpStatus.OK);
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
	
	public List<Lecture> getAllLecture() {
		return dao.getAllLecture();
	}
}
