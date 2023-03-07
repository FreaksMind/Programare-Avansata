package lab3.compulsory;

public class Person implements Comparable<Person>, Node {
	// Al shrafat Maroan
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public Person() {
		this.name = "";
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

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.name);

		return sb.toString();

	}

}
