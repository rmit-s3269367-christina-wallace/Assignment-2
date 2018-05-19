package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class ButtonsInVPane extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Pane pane = new VBox(15);
		pane.getChildren().add(new Button("OK"));
		pane.getChildren().add(new Button("Cancel"));
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("Buttons in a vertical pane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Application.launch(args);
	}

}
