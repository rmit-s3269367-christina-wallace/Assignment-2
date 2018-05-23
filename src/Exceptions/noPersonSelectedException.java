package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class noPersonSelectedException extends Exception {
	
	public noPersonSelectedException() {
		System.err.println("Error: Please enter Person 1 and Person 2.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("No Person Selected Exception");
		alert.setContentText("Please enter Person 1 and Person 2.");
		alert.showAndWait();

	}
}