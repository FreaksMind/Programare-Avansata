package lab3.homework;

import java.util.ArrayList;
import java.util.List;

import lab3.homework.persons.Designer;
import lab3.homework.persons.Programmer;

public class Main {
	// Al shrafat Maroan
	public static void main(String[] args) {
		Network nt = new Network();
		List<Node> nodes = new ArrayList<Node>();

		Person p1 = new Programmer("John");
		Person p2 = new Person("Joan");
		Person p3 = new Designer("Marcel");
		Company c1 = new Company("Oracle");

		nodes.add(p1);
		nodes.add(c1);
		p1.addRelationship(p2, "friend");
		// p2.addRelationship(c1, "SE");
		p1.addRelationship(c1, "CEO");
		p3.addRelationship(p2, "friend");
		p3.addRelationship(p1, "husband");
		p3.addRelationship(c1, "SWE");

		nt.addNode(c1);
		nt.addNode(p1);
		nt.addNode(p3);
		System.out.println(nt);

	}

}