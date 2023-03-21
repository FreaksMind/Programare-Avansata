package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

;

public class Main {

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		
		var projects = IntStream.rangeClosed(0,2).mapToObj(i -> new Project(faker.programmingLanguage().name())).toArray(Project[]::new);
		var students = IntStream.rangeClosed(0,2).mapToObj(i -> new Student(faker.name().fullName())).toArray(Student[]::new);

		Map<Student, List<Project>> projectPrefs = new HashMap<>();
		List<Student> studs = new ArrayList<>();
		List<Project> projs = new ArrayList<>();
		
		studs.addAll(Arrays.asList(students));
		projs.addAll(Arrays.asList(projects));
		
		projectPrefs.put(students[0], Arrays.asList(projects[1], projects[2]));
		projectPrefs.put(students[1], Arrays.asList(projects[0]));
		projectPrefs.put(students[2], Arrays.asList(projects[0], projects[1]));
		
		Problem p = new Problem(projectPrefs);
		System.out.println(p.toString());
		p.displayLowerStudents();
		p.solve();
		
		
	}

}
