package Exceptions;

public class NoSuchAgeException extends Exception {

	public NoSuchAgeException() {
		super();
		System.out.println("Error: Age must be between 0 and 150 years.");
	}
}
