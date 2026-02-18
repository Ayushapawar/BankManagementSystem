package edu.j2ee.e1_sb_db.exceptionHandlers;

public class ResourceNotFoundException
	extends RuntimeException {
	public ResourceNotFoundException(String message){
		super(message);
	}
}
