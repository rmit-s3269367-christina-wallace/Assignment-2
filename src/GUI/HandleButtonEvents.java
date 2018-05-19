package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HandleButtonEvents extends Application {
	public void start(Stage primaryStage) {
		HBox pane = new HBox(10);
		Button btLeft = new Button("Left");
		Button btRight = new Button("Right");
		LeftHandlerClass handler1 = new LeftHandlerClass();
		btLeft.setOnAction(handler1);
		RightHandlerClass handler2 = new RightHandlerClass();
		btRight.setOnAction(handler2);
		pane.getChildren().addAll(btLeft, btRight);
		Scene scene = new Scene(pane);
		primaryStage.setTitle("HandleEvent");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       Application.launch(args);
	}
}
	
class LeftHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Left button clicked");
	}
}

class RightHandlerClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Right button clicked");
	}

}
