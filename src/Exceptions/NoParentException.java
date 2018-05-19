package Exceptions;

public class NoParentException extends Exception {

	public NoParentException() {
		super();
		System.out.println("Error: Children must have two parents who are in a couple.");
	}
}
