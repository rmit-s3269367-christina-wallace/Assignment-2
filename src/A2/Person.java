package A2;

import java.util.ArrayList;

public class Person {
	
	String name;
	String photoURL;
	String status;
	String gender;
	int age;
	String state;
	ArrayList<String> friends;
	ArrayList<String> colleagues;
	ArrayList<String> classmates;
	ArrayList<String> parents;
	
	public Person (String name, String photoURL, String status, String gender, int age, String state) {
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
	}
	
	public Person() {
		String name = null;
		String photoURL = null;
		String status = null;
		String gender = null;
		int age = 0;
		String state = null;
		String parent1 = null;
		String parent2 = null;
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
	
public boolean isChild () {
	if (this.age < 18) {
		return true;
	}
	return false;
} 

public boolean isYoungChild () {
	if (this.age < 2) {
		return true;
	}
	return false;
} 
}
