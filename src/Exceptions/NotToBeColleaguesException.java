package Exceptions;

public class NotToBeColleaguesException extends Exception {

	public NotToBeColleaguesException() {
		super();
		System.out.println("Error: Children are not eligible to be colleagues.");
	}
}