package lab7;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
	private final SharedMemory mem;
	private final ExplorationMap map;
	private final List<Robot> robots = new ArrayList<>();

   public Exploration(int size) {
       mem=new SharedMemory(size);
       map=new ExplorationMap(size);
   }

   public ExplorationMap getMap() {
       return map;
   }

	public void addRobot(Robot robot) {
		robots.add(robot);
	}

   public void start() {
       for (Robot robot : robots) {
    	   Runnable runnable = robot;
           new Thread(runnable).start();
       }
   }
}