package lab4;

public class Student implements Comparable<Student> {

	private String name;

	public Student(String name) {
		this.setName(name);
	}

	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
