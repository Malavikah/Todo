package org.jsp.TodoApp.repository;

import org.jsp.TodoApp.dto.Essay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EssayRepository  extends JpaRepository<Essay, Integer>{

}
