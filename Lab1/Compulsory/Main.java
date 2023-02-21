package lab1;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
		int n = (int) (Math.random() * 1000000);
		n *= 3;
		n += 0b10101;
		n += 0xFF;
		n *= 6;
		
		int newResult = 0;
		while(n != 0) {
			newResult += n % 10;
			n /= 10;
		}
		int finalResult = 0;
		while(newResult != 0) {
			finalResult += newResult % 10;
			newResult /= 10;
		}
		System.out.println("Willy-nilly, this semester I will learn " + languages[finalResult]);
		System.out.println(finalResult);
	}

}
