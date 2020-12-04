package com.cg.ams.exception;


public class RecordNotFoundException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		
	}

	public RecordNotFoundException(String message) {
		super(message);
		
	}

	public RecordNotFoundException(Throwable cause) {
		super(cause);
	
	}

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

}
