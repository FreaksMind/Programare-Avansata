package lab4;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		var projects = IntStream.rangeClosed(0,2).mapToObj(i -> new Project("P"+i)).toArray(Project[]::new);
		var students = IntStream.rangeClosed(0,2).mapToObj(i -> new Student("S"+i)).toArray(Student[]::new);

		List<Student> studs = new LinkedList<>();
		List<Project> projs = new LinkedList<>();
		
		studs.addAll(Arrays.asList(students));
		projs.addAll(Arrays.asList(projects));
		
		Collections.sort(studs, ((u,v) -> u.getName().compareTo(v.getName())));
		Collections.sort(projs, ((u,v) -> u.getName().compareTo(v.getName())));
		
		Set<Project> projectSet = new TreeSet<>(projs);
		
		for(Project p : projectSet) {
			System.out.println(p.getName());
		}
		
		Set<Student> studentSet = new TreeSet<>(studs);
		
		for(Student s : studentSet) {
			System.out.println(s.getName());
		}
		
	}

}
