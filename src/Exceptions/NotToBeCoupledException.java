package Exceptions;

public class NotToBeCoupledException extends Exception {

	public NotToBeCoupledException(String name1, String name2, int age1, int age2) {
		super();
		System.err.println("Error: Children are not allowed to be in a couple.");
		System.err.println(name1 + ": " + Integer.toString(age1) + " years");
		System.err.println(name2 + ": " + Integer.toString(age2) + " years");
	}
}
