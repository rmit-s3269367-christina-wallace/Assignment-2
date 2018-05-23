package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoSuchAgeException extends Exception {

	public NoSuchAgeException() {
		System.err.println("Error: Children under 2 are not eligible to be classmates.");
	}
	
	public NoSuchAgeException(String gui) {
		System.err.println("Error: Error: Age must be between 0 and 150 years.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Error: Age must be between 0 and 150 years.");
		alert.setContentText("Please enter an age between 0 and 150 years.");
		alert.showAndWait();

	}
}
