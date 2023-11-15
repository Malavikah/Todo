package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Lecture;
import org.jsp.TodoApp.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LectureDao {
	@Autowired
	private LectureRepository repository;
	
	public Lecture saveLecture(Lecture lecture) {
		System.out.println(repository);
		return repository.save(lecture);		
	}
	
	public Lecture updateLecture(Lecture lecture) {
		return repository.save(lecture);
	}
	
	public Optional<Lecture> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Lecture> recLecture = findById(id);
		if (recLecture.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Lecture> getAllLecture() {
		return repository.findAll();
	}
}
