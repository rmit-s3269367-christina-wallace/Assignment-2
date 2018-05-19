package A2;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	String name;
	String photoURL;
	String status;
	String gender;
	int age;
	String state;
	String partner;
	ArrayList<String> friends;
	ArrayList<String> colleagues;
	ArrayList<String> classmates;
	ArrayList<String> parents;

	public Person(String name, String photoURL, String status, String gender, int age, String state) {
		this.name = name;
		this.photoURL = photoURL;
		this.status = status;
		this.gender = gender;
		this.age = age;
		this.state = state;
		this.friends = new ArrayList<String>();
		this.colleagues = new ArrayList<String>();
		this.classmates = new ArrayList<String>();
		this.parents = new ArrayList<String>();
		this.partner = null;
	}

	public Person() {
		this.name = null;
		this.photoURL = null;
		this.status = null;
		this.gender = null;
		this.age = 0;
		this.state = null;

	}

	public String getName() {
		return name;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public String getStatus() {
		return status;
	}

	public int getAge() {
		return age;
	}

	public String getState() {
		return state;
	}

	public void addFriend(String person) {
		this.friends.add(person);
	}

	public void addColleague(String person) {
		this.colleagues.add(person);
	}

	public void addClassmate(String person) {
		this.classmates.add(person);
	}

	public void addParent(String person) {
		this.parents.add(person);
	}

	public void addPartner(String person) {
		this.partner = person;
	}

	public boolean hasPartner() {
		if (this.partner != null) {
			return true;
		}
		return false;
	}

	public boolean isChild() {
		if (this.age < 18) {
			return true;
		}
		return false;
	}

	public boolean isYoungChild() {
		if (this.age < 2) {
			return true;
		}
		return false;
	}
	
	public StringProperty nameProperty() {
		return new SimpleStringProperty(this.name);
	}
	
	public StringProperty statusProperty() {
		return new SimpleStringProperty(this.status);
	}
		
	public StringProperty ageProperty() {
		return new SimpleStringProperty(Integer.toString(this.age));
	}
	
	public StringProperty genderProperty() {
		return new SimpleStringProperty(this.gender);
	}
	
	public StringProperty stateProperty() {
		return new SimpleStringProperty(this.state);
	}
	
	public StringProperty photoURLProperty() {
		return new SimpleStringProperty(this.photoURL);
	}
}
