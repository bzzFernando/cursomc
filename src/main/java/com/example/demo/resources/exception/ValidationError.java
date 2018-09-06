package com.example.demo.resources.exception;

import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<FieldMessage> error;

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return error;
	}

	public void setList(List<FieldMessage> list) {
		this.error = list;
	}

	
	public void addError(String fieldName, String messagem) {
		
		error.add(new FieldMessage(fieldName, messagem));
	}
	
}
