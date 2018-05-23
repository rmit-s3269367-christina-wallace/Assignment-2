package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotAvailableException extends Exception {

	public NotAvailableException() {
		System.err.println("Error: One user selected is already in a couple. Adults may only be in one couple at a time.");
	}
	
	public NotAvailableException(String gui) {
		System.err.println("Error: One user selected is already in a couple. Adults may only be in one couple at a time.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Not Available Exception");
		alert.setContentText("One user selected is already in a couple. Adults may only be in one couple at a time.");
		alert.showAndWait();

	}
}