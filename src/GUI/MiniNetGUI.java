package GUI;
import java.util.Map;

import A2.MiniNet;
import A2.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MiniNetGUI extends Application{
	
	private TableView<Person> table = new TableView<Person>();
    private HBox textFields = new HBox();
    private static ObservableList<Person> data = null;
	private static Map<String, Person> users = null;
    
	public static void main(String[] args) {
		
		users = MiniNet.readPeopleFile("people.txt");
        data = FXCollections.observableArrayList();
        data.addAll(users.values());
        
		Application.launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(700);
        stage.setHeight(500);
 
        final Label label = new Label("MiniNet");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        TableColumn statusCol = new TableColumn("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<Person, String>("status"));
        TableColumn ageCol = new TableColumn("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        TableColumn genderCol = new TableColumn("Gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
        TableColumn stateCol = new TableColumn("State");
        stateCol.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
        TableColumn photoCol = new TableColumn("Photo");
        photoCol.setCellValueFactory(new PropertyValueFactory<Person, String>("photoURL"));
        
        table.setItems(data);
        table.getColumns().addAll(nameCol, statusCol, ageCol, genderCol, stateCol, photoCol);
 

        final TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMaxWidth(nameCol.getPrefWidth());
        final TextField addStatus = new TextField();
        addStatus.setMaxWidth(statusCol.getPrefWidth());
        addStatus.setPromptText("Status");
        final TextField addAge = new TextField();
        addAge.setMaxWidth(ageCol.getPrefWidth());
        addAge.setPromptText("Age");
        final TextField addGender = new TextField();
        addGender.setMaxWidth(genderCol.getPrefWidth());
        addGender.setPromptText("Gender");
        final TextField addState = new TextField();
        addState.setMaxWidth(stateCol.getPrefWidth());
        addState.setPromptText("State");
        final TextField addPhoto = new TextField();
        addPhoto.setMaxWidth(photoCol.getPrefWidth());
        addPhoto.setPromptText("Photo");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                users.put(addName.getText(), new Person(
                        	addName.getText(),
                        	addPhoto.getText(),
                        	addStatus.getText(),
                			addGender.getText(),
                			Integer.parseInt(addAge.getText()),
                			addState.getText()));
                
                data.clear();
                data.addAll(users.values());
                
        			addName.clear();
        			addPhoto.clear();
        			addStatus.clear();
        			addGender.clear();
        			addAge.clear();
        			addState.clear();
            }
        });
 
        final Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            		
            		Person person = table.getSelectionModel().getSelectedItem();
            		
                users.remove(person.getName());
                data.clear();
                data.addAll(users.values());
                
            }
        });
 
        
        textFields.getChildren().addAll(addName, addPhoto, addStatus, addGender, addAge, addState, addButton, deleteButton);
        textFields.setSpacing(3);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, textFields);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
	}

}
