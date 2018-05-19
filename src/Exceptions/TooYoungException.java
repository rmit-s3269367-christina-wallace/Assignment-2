package Exceptions;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TooYoungException extends Exception {

	public TooYoungException(String p1name, String p2name, int age1, int age2) {
		super();
		if (age1 < 2) {
		System.err.println("Error: One of these children is too young to make friends.");
		System.err.println(p1name + ": " + Integer.toString(age1) + "years.");
		System.err.println(p2name + ": " + Integer.toString(age2) + "years.");
		}
	}	
}
