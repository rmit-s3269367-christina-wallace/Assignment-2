package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NoOneSelectedException extends Exception {

	public NoOneSelectedException() {
		System.err.println("Please select a person from the list.");
	}
	
	public NoOneSelectedException(String gui) {
		System.err.println("Please select a person from the list.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("No person selected.");
		alert.setContentText("Please select a person from the list. Then click 'Show Relationships'.");
		alert.showAndWait();

	}
}