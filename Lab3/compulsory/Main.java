package lab3.compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main {
	//Al shrafat Maroan
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<Node>();

		Person p1 = new Person("John");
		Company c1 = new Company("Oracle");

		nodes.add(p1);
		nodes.add(c1);

		for (Node n : nodes) {
			System.out.println(n);
		}

	}

}
