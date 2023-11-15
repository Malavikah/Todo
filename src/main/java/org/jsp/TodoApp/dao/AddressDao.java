package org.jsp.TodoApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dto.Address;
import org.jsp.TodoApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepository repository;
	
	public Address saveAddress(Address address) {
		System.out.println(repository);
		return repository.save(address);		
	}
	
	public Address updateAddress(Address address) {
		return repository.save(address);
	}
	
	public Optional<Address> findById(int id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Address> recAddress = findById(id);
		if (recAddress.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Address> getAllAddresses() {
		return repository.findAll();
	}
}
