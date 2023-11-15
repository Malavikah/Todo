package org.jsp.TodoApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.TodoApp.dao.AddressDao;
import org.jsp.TodoApp.dto.Address;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		address = dao.saveAddress(address);
		structure.setData(address);
		structure.setMessage("Message registered successfully"+ address.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		ResponseStructure<Address> structure = new ResponseStructure<>();
		address = dao.updateAddress(address);
		structure.setData(address);
		structure.setMessage("Message updateded successfully"+ address.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Address>> findById(int id) {
		Optional<Address> recAddress = dao.findById(id);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		if (recAddress.isPresent()) 
		{
			structure.setData(recAddress.get());
			structure.setMessage("Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
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
	
	public List<Address> getAllAddress() {
		return dao.getAllAddresses();
	}

}
