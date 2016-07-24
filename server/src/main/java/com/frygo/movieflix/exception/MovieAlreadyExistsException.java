package com.frygo.movieflix.exception;

public class MovieAlreadyExistsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieAlreadyExistsException(String message){
		super (message);
	}
	public MovieAlreadyExistsException(String message,Throwable cause){
		super (message,cause);
	}
}
