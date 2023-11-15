package org.jsp.TodoApp.repository;

import org.jsp.TodoApp.dto.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer>{
	
}
