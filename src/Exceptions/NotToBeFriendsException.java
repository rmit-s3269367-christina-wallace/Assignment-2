package Exceptions;

public class NotToBeFriendsException extends Exception {

	public NotToBeFriendsException() {
		super();
		System.out.println("Error: These two are not eligible to be friends. (Either adult and child or two children with an age gap greater than 3 years).");
	}
}
