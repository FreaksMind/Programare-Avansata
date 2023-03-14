package lab3.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Network {
	//Al shrafat Maroan
	private List<Node> nodes = new ArrayList<>();

	public void addNode(Node node) {
		nodes.add(node);
	}

	private int getNodeIndex(Node n) {
		for (int i = 0; i < nodes.size(); ++i) {
			if (nodes.get(i).equals(n))
				return i;
		}
		return -1;
	}

	public int computeImportance(Node node) {
		if (!nodes.contains(node)) {
			System.out.println("Nu exista!");
			System.exit(-1);
		}
		if (node instanceof Person) {
			Person p = (Person) nodes.get(getNodeIndex(node));
			return p.getRelations().size();
		} else {
			int importance = 0;
			for (Node n : nodes) {
				if (n instanceof Person) {
					Person person = (Person) n;
					for (Node nodeC : person.getRelations().keySet()) {
						if (nodeC.getName().equals(node.getName()))
							importance++;
					}
				}
			}
			return importance;
		}
	}

	private String printRelationships() {
		StringBuilder sb = new StringBuilder();

		for (Node n : nodes) {
			if (n instanceof Person) {
				Person p = (Person) n;
				for (Node relation : p.getRelations().keySet()) {
					if (relation instanceof Person) {
						sb.append(n.getName()).append(" ").append(p.getRelations().get(relation)).append(" of ")
								.append(relation.getName()).append("\n");
					} else {
						sb.append(n.getName()).append(" ").append(p.getRelations().get(relation)).append(" at ")
								.append(relation.getName()).append("\n");
					}
				}

			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		Collections.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return computeImportance(n2) - computeImportance(n1);
			};
		});
		
		
		return printRelationships();
	}

}
