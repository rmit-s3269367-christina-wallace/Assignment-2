package Exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NotToBeClassmatesException extends Exception {

		public NotToBeClassmatesException() {
			System.err.println("Error: Children under 2 are not eligible to be classmates.");
		}
		
		public NotToBeClassmatesException(String gui) {
			System.err.println("Error: Children under 2 are not eligible to be classmates.");
				
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Not to be Classmates Exception");
			alert.setContentText("under 2 are not eligible to be classmates.");
			alert.showAndWait();

		}
}