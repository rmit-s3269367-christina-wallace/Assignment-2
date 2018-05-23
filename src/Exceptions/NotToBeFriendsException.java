package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotToBeFriendsException extends Exception {

	public NotToBeFriendsException() {
		System.err.println("Error: These two are not eligible to be friends. (Either adult and child or two children with an age gap greater than 3 years).");
	}
	
	public NotToBeFriendsException(String gui) {
		System.err.println("Error: These two are not eligible to be friends. (Either adult and child or two children with an age gap greater than 3 years).");
			
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Not to be Friends Exception");
		alert.setContentText("Adults must not be friends with children. \nChildren must not be friends with other children with an age gap greater than 3 years.");
		alert.showAndWait();

	}
}
		
		
		
		
		

