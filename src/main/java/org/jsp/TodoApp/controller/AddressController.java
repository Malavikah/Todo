package org.jsp.TodoApp.controller;

import java.util.List;

import org.jsp.TodoApp.dto.Address;
import org.jsp.TodoApp.dto.ResponseStructure;
import org.jsp.TodoApp.service.AddressService;
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
public class AddressController {
	@Autowired
	private AddressService service;
	
	@PostMapping("/addresses")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address){
		return service.saveAddress(address);
	}
	
	@PutMapping("/addresses/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address, @PathVariable int id){
		return service.updateAddress(address);
	}
	
	@GetMapping("/addresses/{id}")
	public ResponseEntity<ResponseStructure<Address>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@GetMapping("/addresses")
	public List<Address> getAllAddress(){
		return service.getAllAddress();
	}
	
	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
}
