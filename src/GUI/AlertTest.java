package GUI;

import javafx.application.Application;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class AlertTest extends Application {

	//A radio button with an empty string for its label
	RadioButton rb1 = new RadioButton("Home");
	//Setting a text label
	//A radio button with the specified label
	RadioButton rb2 = new RadioButton("Calendar");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

