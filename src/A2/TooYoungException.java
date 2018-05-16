package A2;

public class TooYoungException extends Exception {

	public TooYoungException() {
		super();
		System.out.println("This child is too young to make friends.");
	}
}
