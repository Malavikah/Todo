package org.jsp.TodoApp.repository;


import org.jsp.TodoApp.dto.WeeklyPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyPlannerRepository extends JpaRepository<WeeklyPlanner, Integer>{

}
