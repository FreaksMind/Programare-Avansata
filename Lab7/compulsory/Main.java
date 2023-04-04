package lab7;

public class Main {

	public static void main(String args[]) {
		var explore = new Exploration(100);
		explore.addRobot(new Robot("Wall-E", 100));
		explore.addRobot(new Robot("R2D2", 100));
		explore.addRobot(new Robot("Optimus Prime", 100));
		explore.start();
	}
}
