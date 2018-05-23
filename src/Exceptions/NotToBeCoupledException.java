package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotToBeCoupledException extends Exception {

	public NotToBeCoupledException() {
		System.err.println("Error: Children under 18 are not eligible to be in a couple.");
	}
	
	public NotToBeCoupledException(String gui) {
		System.err.println("Error: Children under 18 are not eligible to be in a couple.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Not To Be Coupled Exception");
		alert.setContentText("Children under 18 are not eligible to be in a couple.");
		alert.showAndWait();

	}
}