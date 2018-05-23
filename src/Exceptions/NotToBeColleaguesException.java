package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotToBeColleaguesException extends Exception {

	public NotToBeColleaguesException() {
		System.err.println("Error: Children are not eligible to be colleagues.");
	}
	
	public NotToBeColleaguesException(String gui) {
		System.err.println("Error: Children are not eligible to be colleagues.");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Not to be Colleagues Exception");
		alert.setContentText("Children are not eligible to be colleagues.");
		alert.showAndWait();

	}
}