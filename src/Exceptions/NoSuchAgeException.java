package Exceptions;

public class NoSuchAgeException extends Exception {

	public NoSuchAgeException(String name) {
		super();
		System.err.println("Error: Age must be between 0 and 150 years. Incorrect record for " + name + ".");
	}
}
