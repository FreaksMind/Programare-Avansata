package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem {

	private Map<Student, List<Project>> projectPrefs = new HashMap<>();
	private Map<Student, Project> assignedProjs = new HashMap<>();
	private Set<Project> projects = new TreeSet<>();
	private Set<Student> students = new TreeSet<>();

	public Problem(Map<Student, List<Project>> projectPrefs) {
		this.projectPrefs.putAll(projectPrefs);
		for (Student s : projectPrefs.keySet()) {
			students.add(s);
			for (Project p : projectPrefs.get(s)) {
				projects.add(p);
			}
		}
	}

	public void displayLowerStudents() {

		int averagePrefs = (int) projectPrefs.keySet().stream().mapToInt(i -> projectPrefs.get(i).size()).average()
				.orElse(0);

		System.out.println("Students that have a number of preferences lower than the average number of preferences: ");
		projectPrefs.keySet().stream().filter(s -> projectPrefs.get(s).size() < averagePrefs)
				.forEach(System.out::println);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Students:\n");
		for (Student s : students) {
			sb.append(" ").append(s.getName() + "\n");
		}
		sb.append("Projects:\n");
		for (Project p : projects) {
			sb.append(" ").append(p.getName() + "\n");
		}

		return sb.toString();
	}

	public void solve() {
		for (Student s : projectPrefs.keySet()) {
			for (Project p : projectPrefs.get(s)) {
				if (projects.contains(p)) {
					assignedProjs.put(s, p);
					projects.remove(p);
					students.remove(s);
				}
				break;
			}
		}
		List<Project> projList = new ArrayList<>(projects);
		if (students.size() != 0) {
			for (Student s : students) {
				if (projects.size() == 0)
					break;
				assignedProjs.put(s, projList.get(0));
				projects.remove(projList.get(0));
				students.remove(s);
			}
		}
		System.out.println("Final project list: ");
		for (Student s : assignedProjs.keySet()) {
			System.out.println(" " + s.getName() + " -> " + assignedProjs.get(s).getName());
		}

	}

}
