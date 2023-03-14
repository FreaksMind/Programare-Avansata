package lab3.homework.persons;

import lab3.homework.Person;

public class Designer extends Person {

	private int salary;
	
	public Designer(String name) {
		super(name);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
