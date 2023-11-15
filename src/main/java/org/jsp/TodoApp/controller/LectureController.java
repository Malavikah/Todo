package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Lecture;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.LectureService;
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
public class LectureController {
	@Autowired
	private LectureService service;
	
	@PostMapping("/lecture")
	public ResponseEntity<ResponseStructure<Lecture>> saveLecture(@RequestBody Lecture lecture){
		return service.saveLecture(lecture);
	}
	
	@PutMapping("/lecture/{id}")
	public ResponseEntity<ResponseStructure<Lecture>> updateLecture(@RequestBody Lecture lecture, @PathVariable int id){
		return service.updateLecture(lecture);
	}
	
	@GetMapping("/lecture/{id}")
	public ResponseEntity<ResponseStructure<Lecture>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/lecture/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@GetMapping("/lecture")
	public List<Lecture> getAllLecture(){
		return service.getAllLecture();
	}
	
}
