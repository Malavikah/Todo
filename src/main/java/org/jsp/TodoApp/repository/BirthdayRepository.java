package org.jsp.TodoApp.repository;

import org.jsp.TodoApp.dto.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday, Integer>{

}
