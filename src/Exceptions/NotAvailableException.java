package Exceptions;

public class NotAvailableException extends Exception {

	public NotAvailableException() {
		super();
		System.out.println("Error: You cannot be in more than one couple.");
	}
}