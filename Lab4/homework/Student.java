package lab4;

public class Student implements Comparable<Student> {

	private String name;

	public Student(String name) {
		this.setName(name);
	}

	public int compareTo(Student o) {
		return this.name.compareTo(o.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		
		return this.name;
	}
}
