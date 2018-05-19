package A2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Exceptions.NoParentException;
import Exceptions.NoSuchAgeException;
import Exceptions.NonSpecifiedRelationshipException;
import Exceptions.NotAvailableException;
import Exceptions.NotToBeClassmatesException;
import Exceptions.NotToBeColleaguesException;
import Exceptions.NotToBeCoupledException;
import Exceptions.NotToBeFriendsException;
import Exceptions.TooYoungException;

public class MiniNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Person> users = null;

		users = readPeopleFile("people.txt");
		// System.out.println(users.keySet().toArray()[0]);
		for (String key : users.keySet()) {
			System.out.println(key);
		}
		readRelationshipsFile("relations.txt", users);
	}

	public static Map<String, A2.Person> readPeopleFile(String fileName) {

		String name = null;
		String photoURL = null;
		String status = null;
		String gender = null;
		int age = 0;
		String state = null;

		Map<String, Person> users = new HashMap<String, Person>();

		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));

			String next = input.readLine();

			while (next != null) {

				String[] a = next.split(",");
				name = a[0].trim();
				photoURL = a[1].trim();
				status = a[2].trim();
				gender = a[3].trim();
				age = Integer.parseInt(a[4].trim());
				state = a[5].trim();

				try {
					if (age < 0 || age > 150) {
						throw new NoSuchAgeException(name);
					}
					
					Person p = new Person(name, photoURL, status, gender, age, state);
					users.put(name, p);

				} catch (NoSuchAgeException e) {
					// Ignore record.
				}

				next = input.readLine();
			}

			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}

		return users;
	}

	public static void readRelationshipsFile(String fileName, Map<String, Person> users) {
		String person1 = null;
		String person2 = null;
		String relationship = null;
		int ageDifference = 0;

		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));

			String next = input.readLine();

			while (next != null) {
				System.out.println(next);
				String[] b = next.split(",");
				person1 = b[0].trim();
				person2 = b[1].trim();
				relationship = b[2].trim();

				Person p1 = users.get(person1);
				Person p2 = users.get(person2);

				// Add exception to catch p1, p2 null
				
				try {
					if (relationship.equals("friends")) {
						if (p1.isYoungChild() || p2.isYoungChild()) {
							throw new TooYoungException(p1.getName(), p2.getName(), p1.getAge(), p2.getAge());
						}
	
						if ((p1.isChild() && !p2.isChild()) || (p2.isChild() && !p1.isChild())) {
							throw new NotToBeFriendsException();
						}
	
						if (p1.isChild() && p2.isChild()) {
							ageDifference = Math.abs(p1.getAge() - p2.getAge());
							if (ageDifference > 3) {
								throw new NotToBeFriendsException();
							}
						}
	
						p1.addFriend(person2);
						p2.addFriend(person1);
					} else if (relationship.equals("colleagues")) {
						if (p1.isChild() || p2.isChild()) {
							throw new NotToBeColleaguesException();
						}
						p1.addColleague(person2);
						p2.addColleague(person1);
					} else if (relationship.equals("classmates")) {
						if (p1.isYoungChild() || p2.isYoungChild()) {
							throw new NotToBeClassmatesException();
						}
	
						p1.addClassmate(person2);
						p2.addClassmate(person1);
	
						// Parent Relationship: Always must be second parent because if there is no
						// couple, exception will be thrown.
					} else if (relationship.equals("parent")) {
						if (p1.isChild() || p1.isYoungChild()) {
							if (!p2.hasPartner()) {
								throw new NoParentException();
							}
						}
						if (p2.isChild() || p2.isYoungChild()) {
							if (!p1.hasPartner()) {
								throw new NoParentException();
							}
						}
	
						if (p1.isChild()) {
							if (!p2.isChild()) {
								p1.addParent(person2);
							}
						} else if (p2.isChild()) {
							if (!p1.isChild()) {
								p2.addParent(person1);
							}
						}
	
					} else if (relationship.equals("couple")) {
						if (p1.isChild() || p2.isChild()) {
							throw new NotToBeCoupledException(p1.getName(), p2.getName(), p1.getAge(), p2.getAge());
						}
						if ((p1.hasPartner() == true) || (p2.hasPartner() == true)) {
							throw new NotAvailableException();
						}
	
						p1.addPartner(person2);
						p2.addPartner(person1);
	
					} else {
						throw new NonSpecifiedRelationshipException(relationship, p1.getAge(), p2.getAge());
					}
				} catch (TooYoungException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotToBeFriendsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotToBeColleaguesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotToBeClassmatesException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NonSpecifiedRelationshipException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotToBeCoupledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotAvailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoParentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				next = input.readLine();
			}

			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
	}
}
