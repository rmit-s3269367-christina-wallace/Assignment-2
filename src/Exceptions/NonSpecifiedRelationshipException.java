package Exceptions;

public class NonSpecifiedRelationshipException extends Exception {

	public NonSpecifiedRelationshipException(String relationship, int age1, int age2) {
		super();
		System.err.println("Error: Relationship type must be either friends, colleagues, classmates or partners. Incorrect relationship for " + relationship + ".");
		System.err.println(Integer.toString(age1) + " " + Integer.toString(age2));
	}
}