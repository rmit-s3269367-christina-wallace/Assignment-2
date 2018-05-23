package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TooYoungException extends Exception {

	public TooYoungException(String p1name, String p2name, int age1, int age2) {
		super();
		if (age1 < 2) {
		System.err.println("Error: One of these children is too young to make friends.");
		System.err.println(p1name + ": " + Integer.toString(age1) + "years.");
		System.err.println(p2name + ": " + Integer.toString(age2) + "years.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Too Young Exception");
		alert.setContentText("One of these children is too young to make friends.");
		alert.showAndWait();

		}
	}
	
	
}
