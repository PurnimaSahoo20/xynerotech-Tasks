package com.ps.doctor_booking_api.exception;

public class ResourceNotFoundException extends RuntimeException{
	 public ResourceNotFoundException(String message) {
	        super(message);
	    }
}
