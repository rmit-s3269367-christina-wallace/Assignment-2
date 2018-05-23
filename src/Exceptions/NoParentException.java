package Exceptions;

public class NoParentException extends Exception {

	public NoParentException(String name) {
		super();
		System.err.println("Error: Children must have two parents who are in a couple.");
		System.err.println(name + " is not in a couple.");
	}
}
