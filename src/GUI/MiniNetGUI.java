package GUI;

import java.util.Map;

import A2.MiniNet;
import A2.Person;
import Exceptions.NoOneSelectedException;
import Exceptions.NotAvailableException;
import Exceptions.NotToBeClassmatesException;
import Exceptions.NotToBeColleaguesException;
import Exceptions.NotToBeCoupledException;
import Exceptions.NotToBeFriendsException;
import Exceptions.TooYoungException;
import Exceptions.noPersonSelectedException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MiniNetGUI extends Application {

	private TableView<Person> personTable = new TableView<Person>();
	private TableView<Person> relationshipTable = new TableView<Person>();
	private HBox textFields = new HBox();
	private HBox textFields2 = new HBox();
	private HBox textFields3 = new HBox();
	private HBox textFields4 = new HBox();
	private HBox textFields5 = new HBox();
	private HBox textFields6 = new HBox();
	private static ObservableList<Person> data = null;
	private static Map<String, Person> users = null;

	String person1 = null;
	String person2 = null;
	int ageDifference = 0;

	Person p1;
	Person p2;

	/*
	 * Map<String, Person> users = new HashMap<String, Person>(); Person p1 =
	 * users.get(person1); Person p2 = users.get(person2);
	 */

	public static void main(String[] args) {

		users = MiniNet.readPeopleFile("people.txt");
		MiniNet.readRelationshipsFile("relations.txt", users);
		data = FXCollections.observableArrayList();
		data.addAll(users.values());

		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("MiniNet View");
		stage.setWidth(1000);
		stage.setHeight(1000);

		final Label label = new Label("MiniNet");
		label.setFont(new Font("Arial", 20));

		personTable.setEditable(true);
		relationshipTable.setEditable(true);

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

		personTable.setItems(data);
		personTable.getColumns().addAll(nameCol, statusCol, ageCol, genderCol, stateCol, photoCol);

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

		final TextField displayField = new TextField();
		displayField.setMinWidth(300);
		displayField.setPromptText("Display");

		final TextField displayField2 = new TextField();
		displayField2.setMinWidth(300);
		displayField2.setPromptText("Display 2");

		final TextField displayField3 = new TextField();
		displayField3.setMinWidth(300);
		displayField3.setPromptText("Display 3");

		final TextArea displayField4 = new TextArea();
		displayField4.setMinWidth(600);
		displayField4.setMinHeight(100);
		displayField4.setPromptText("Display 4");

		final TextField displayField5 = new TextField();
		displayField5.setMinWidth(600);
		displayField5.setMinHeight(30);
		displayField5.setPromptText("Instruction Text");

		final Button addButton = new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				users.put(addName.getText(), new Person(addName.getText(), addPhoto.getText(), addStatus.getText(),
						addGender.getText(), Integer.parseInt(addAge.getText()), addState.getText()));

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

				Person p1 = users.get(personTable.getSelectionModel().getSelectedItem().getName());
				
				for (String person2 : p1.getFriends()) {
					Person p2 = users.get(person2);
					p2.removeFriend(p1.getName());
				}
				
				for (String person2 : p1.getColleagues()) {
					Person p2 = users.get(person2);
					p2.removeColleague(p1.getName());
				}
				
				for (String person2 : p1.getClassmates()) {
					Person p2 = users.get(person2);
					p2.removeClassmate(p1.getName());
				}
				
				users.get(p1.getName()).removePartner();
				
				for (String person2 : p1.getParents()) {
					Person p2 = users.get(person2);
					p2.removeParent(p1.getName());
				}
				
				
				
				users.remove(p1.getName());
				data.clear();
				data.addAll(users.values());
				

			}
		});

		final Button exitButton = new Button("Exit");
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		final Button showParentsButton = new Button("Show parents");
		showParentsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Person person = personTable.getSelectionModel().getSelectedItem();
				displayField.setText(person.showParents());
			}
		});

		final Button showChildrenButton = new Button("Show Children");
		showChildrenButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Person person = personTable.getSelectionModel().getSelectedItem();
				displayField.setText(person.showChildren());
			}
		});

		final Button addRelationButton = new Button("Add New Relationship");
		addRelationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				displayField5.setText("Select first person to connect. Then click 'Person 1'");
			}
		});

		final Button showRelationshipsButton = new Button("Show Relationships");
		showRelationshipsButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				p1 = users.get(personTable.getSelectionModel().getSelectedItem().getName());
				if (p1 == null) {
					try {
						throw new NoOneSelectedException("gui");
					} catch (NoOneSelectedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					displayField4
							.setText(p1.getName() + "'s Relationships: \n" + p1.showFriends() + "\n" + p1.showClassmates()
									+ "\n" + p1.showColleagues() + "\n" + p1.showParents() + "\n" + p1.showPartner());
				}
			}
		});

		final Button showPersonSelectedButton = new Button("Person 1");
		showPersonSelectedButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				p1 = users.get(personTable.getSelectionModel().getSelectedItem().getName());
				displayField2.setText(p1.getName());
				displayField5.setText("Select second person then click Person 2.");
			}
		});

		final Button showPerson2SelectedButton = new Button("Person 2");
		showPerson2SelectedButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				p2 = users.get(personTable.getSelectionModel().getSelectedItem().getName());
				displayField3.setText(p2.getName());
				displayField5.setText("Choose relationship to add, then click 'Add Relationship'.");
			}
		});

		final ToggleGroup group = new ToggleGroup();

		RadioButton rb1 = new RadioButton("Friends");
		rb1.setToggleGroup(group);
		rb1.setSelected(true);

		RadioButton rb2 = new RadioButton("Classmates");
		rb2.setToggleGroup(group);

		RadioButton rb3 = new RadioButton("Colleagues");
		rb3.setToggleGroup(group);

		RadioButton rb4 = new RadioButton("Parents");
		rb4.setToggleGroup(group);

		RadioButton rb5 = new RadioButton("Couple");
		rb5.setToggleGroup(group);

		rb1.setUserData("Friends");
		rb2.setUserData("Classmates");
		rb3.setUserData("Colleagues");
		rb4.setUserData("Parents");
		rb5.setUserData("Couple");

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
				if (group.getSelectedToggle() != null) {
					System.out.println(group.getSelectedToggle().getUserData());
				}
			}
		});

		final Button addRelationshipButton = new Button("Add Relationship");
		addRelationshipButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				try {
					if (group.getSelectedToggle().getUserData().equals("Friends")) {
						if (p1 == null || p2 == null) {
							throw new noPersonSelectedException();
						}
						System.out.println(p1.getName() + ' ' + p2.getName());

						if (p1.isYoungChild() || p2.isYoungChild()) {
							throw new TooYoungException(p1.getName(), p2.getName(), p1.getAge(), p2.getAge());

						} else if ((p1.isChild() && !p2.isChild()) || (p2.isChild() && !p1.isChild())) {
							throw new NotToBeFriendsException("gui");
						}

						if (p1.isChild() && p2.isChild()) {
							ageDifference = Math.abs(p1.getAge() - p2.getAge());
							if (ageDifference > 3) {
								throw new NotToBeFriendsException("gui");
							}
						}
						p1.addFriend(p2.getName());
						p2.addFriend(p1.getName());
					} else if (group.getSelectedToggle().getUserData().equals("Colleagues")) {
						if (p1.isChild() || p2.isChild()) {
							throw new NotToBeColleaguesException("gui");
						}
						p1.addColleague(p2.getName());
						p2.addColleague(p1.getName());
					} else if (group.getSelectedToggle().getUserData().equals("Classmates")) {
						if (p1.isYoungChild() || p2.isYoungChild()) {
							throw new NotToBeClassmatesException("gui");
						}
						p1.addClassmate(p2.getName());
						p2.addClassmate(p1.getName());
					} else if (group.getSelectedToggle().getUserData().equals("Couple")) {
						if (p1.isChild() || p2.isChild()) {
							throw new NotToBeCoupledException("gui");
						}
						if (p1.hasPartner() == true) {
							throw new NotAvailableException("gui");
						} else if (p2.hasPartner() == true) {
							throw new NotAvailableException("gui");
						}

						p1.addPartner(p2.getName());
						p2.addPartner(p1.getName());
					}
				} catch (TooYoungException e1) {
				} catch (NotToBeFriendsException e1) {
				} catch (noPersonSelectedException e1) {
				} catch (NotToBeColleaguesException e1) {
				} catch (NotToBeClassmatesException e1) {
				} catch (NotToBeCoupledException e1) {
				} catch (NotAvailableException e1) {
				}

				System.out.println("Relationship has been added.'");

			}

			private Window getPrimaryStage() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		{

			textFields.getChildren().addAll(addName, addPhoto, addStatus, addGender, addAge, addState, addButton,
					deleteButton, exitButton, showParentsButton, showChildrenButton, displayField);
			textFields.setSpacing(3);

			textFields2.getChildren().addAll(showParentsButton, showChildrenButton, displayField);
			textFields2.setSpacing(3);

			textFields3.getChildren().addAll(showPersonSelectedButton, showPerson2SelectedButton, displayField2,
					displayField3);
			textFields3.setSpacing(3);

			textFields4.getChildren().addAll(rb1, rb2, rb3, rb4, rb5, addRelationshipButton);
			textFields4.setSpacing(3);

			textFields5.getChildren().addAll(showRelationshipsButton, displayField4);
			textFields5.setSpacing(3);

			textFields6.getChildren().addAll(addRelationButton, displayField5);
			textFields6.setSpacing(3);

			final VBox vbox = new VBox();

			vbox.setSpacing(5);
			vbox.setPadding(new Insets(10, 0, 0, 10));
			vbox.getChildren().addAll(label, personTable, textFields, textFields6, textFields3, textFields4,
					textFields2, textFields5);

			((Group) scene.getRoot()).getChildren().addAll(vbox);

			stage.setScene(scene);
			stage.show();
		}
		;
	}
}
