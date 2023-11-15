package org.jsp.TodoApp.repository;

import org.jsp.TodoApp.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
