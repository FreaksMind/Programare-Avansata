package lab12.compulsory;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws MalformedURLException, SecurityException, ClassNotFoundException {
		
		ClassLoader loader = new ClassLoader();
		int passed = 0;
		int failed = 0;

		String pathForClass = "D:/eclipse-workspace/Lab4/src/main/java/lab12/compulsory/User.class";
		File pathClass = new File(pathForClass);
		if (pathClass.exists()) {
			URL urlClass = pathClass.toURI().toURL();
			loader.addURL(urlClass);
		}

		Class c = loader.loadClass("lab12.compulsory.User");
		
		System.out.println("Package: " + loader.loadClass("lab12.compulsory.User").getPackageName());
		System.out.println("Variables: ");
		for (Field fields : c.getDeclaredFields()) {
			System.out.println("\t" + fields.getName());
		}
		
		System.out.println(" ");
		System.out.println("Methods: ");
		for (Method methods : c.getMethods()) {
			System.out.println("\t" + methods.getName());
		}
		
		
		for (Method methods : c.getMethods()) {
			System.out.println("\t" + methods.getName());
		}
		

		for (Method methods : loader.loadClass("lab12.compulsory.TestClass").getMethods()) {
			if (methods.isAnnotationPresent(Test.class)) {
				try {
					methods.invoke(null);
					passed++;
				} catch (Throwable ex) {
					System.out.printf("Test %s failed at %s\n", methods, ex.getCause());
					failed++;
				}
			}
		}
		System.out.printf("Total passed: %d, Total failed %d%n", passed, failed);
	}

}
