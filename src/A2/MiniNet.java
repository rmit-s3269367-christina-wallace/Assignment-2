package A2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MiniNet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Person> users;
		users = readPeopleFile("people.txt");
		readRelationshipsFile("relations.txt", users);
	}

	public static Map<String, A2.Person> readPeopleFile(String fileName) throws NoSuchAgeException{

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
				
				if (age < 0 || age > 150) {
					throw new NoSuchAgeException();
				}

				Person p = new Person(name, photoURL, status, gender, age, status);

				users.put(name, p);

				next = input.readLine();
			}

			input.close();

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}

		return users;
	}

	public static void readRelationshipsFile(String fileName, Map<String, Person> users)
			throws TooYoungException, NotToBeFriendsException, NotToBeColleaguesException {
		String person1 = null;
		String person2 = null;
		String relationship = null;
		int ageDifference = 0;

		try {
			BufferedReader input = new BufferedReader(new FileReader("relations.txt"));

			String next = input.readLine();

			while (next != null) {
				System.out.println(next);
				String[] b = next.split(",");
				person1 = b[0].trim();
				person2 = b[1].trim();
				relationship = b[2].trim();

				Person p1 = users.get(person1);
				Person p2 = users.get(person2);

				if (relationship == "friends") {
					if (p1.isYoungChild() || p2.isYoungChild()) {
						throw new TooYoungException();
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
				} else if (relationship == "colleagues") {
					if (p1.isChild() || p2.isChild()) {
						throw new NotToBeColleaguesException();
					}
					
					p1.addColleague(person2);
					p2.addColleague(person1);
				} else if (relationship == "classmates") {
					p1.addClassmate(person2);
					p2.addClassmate(person1);
				} else if (relationship == "parent") {
					if (p1.isChild()) {
						if (!p2.isChild()) {
							p1.addParent(person2);
						}
					} else if (p2.isChild()) {
						if (!p1.isChild()) {
							p2.addParent(person1);
						}
					}
				} else {

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
