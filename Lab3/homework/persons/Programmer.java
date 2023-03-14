package lab3.homework.persons;

import java.util.ArrayList;
import java.util.List;

import lab3.homework.Person;

public class Programmer extends Person {

	private List<String> knownTechnologies = new ArrayList<>();
	
	public Programmer(String name) {
		super(name);
	}
	
	public List<String> getKnownTechnologies() {

		return knownTechnologies;

	}
	
	public void addKnownTechnology(String technology) {
		for (String t : knownTechnologies) {
			if(t.equals(technology)) {
				System.out.println("Technology already known!");
				System.exit(-1);
			}
		}
		knownTechnologies.add(technology);
	}
	
}
