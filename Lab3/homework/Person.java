package lab3.homework;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person implements Comparable<Person>, Node {
	// Al shrafat Maroan
	private String name;
	private Date birthDate;
	private Map<Node, String> relationships = new HashMap<Node, String>();

	public Person(String name) {
		this.name = name;
	}

	public Person() {
		this.name = "";
	}

	public Person addRelationship(Person p, String relation) {

		if (this.compareTo(p) == 0) {
			System.out.println("You can't add a relationship to yourself!");
			System.exit(-1);
		}

		for (Node person : relationships.keySet()) {
			if (person.equals(p)) {
				System.out.println("You can't add the same relationship twice!");
				System.exit(-1);
			}
		}
		relationships.put(p, relation);

		return this;
	}

	public Person addRelationship(Company c, String relation) {

		for (Node company : relationships.keySet()) {
			if (company.equals(c)) {
				System.out.println("You can't add the same relationship twice!");
				System.exit(-1);
			}
		}
		relationships.put(c, relation);

		return this;
	}

	@Override
	public int compareTo(Person o) {

		if (o == null)
			return 0;
		return this.name.compareTo(o.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Map<Node, String> getRelations() {

		return relationships;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.name);

		return sb.toString();

	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}