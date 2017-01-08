package com.mar1.exception;


public class ToDoException extends Exception{
	
	private String errorMessage;

	
	public String getErrorMessage() {
		return errorMessage;
	}

	public ToDoException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ToDoException() {
		super();
	}
	
	
	
	

}
