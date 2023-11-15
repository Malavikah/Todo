package org.jsp.TodoApp.exception;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid";
	}
}
