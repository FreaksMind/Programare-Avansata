package lab2.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem {

	private List<Road> roads = new ArrayList<Road>();
	private Map<Location, Integer> locations = new HashMap<Location, Integer>();
	private int[][] graph;

	public Problem() {
	}

	public boolean isValid() {

		return false;
	}

	/**
	 * It initialize and update the matrix of the graph and checks using a BFS
	 * traversal if you can get from the first location to the second
	 * 
	 * @param first  location
	 * @param second location
	 * @return a boolean indicating if you can get from location a to location b
	 */
	public boolean solve(Location a, Location b) {

		graph = new int[locations.size()][locations.size()];

		for (Road r : roads) {
			graph[locations.get(r.getStartPoint())][locations.get(r.getFinishPoint())] = 1;
			graph[locations.get(r.getFinishPoint())][locations.get(r.getStartPoint())] = 1;
		}

		if (a.equals(b))
			return true;

		int indexA = locations.get(a);
		int indexB = locations.get(b);

		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[locations.size()];

		queue.add(indexA);
		visited[indexA] = true;
		while (!queue.isEmpty()) {

			int vertex = queue.remove();

			for (int i = 0; i < locations.size(); ++i) {
				if (graph[i][vertex] == 1 && i == indexB) {
					return true;
				}

				if (!visited[graph[i][vertex]]) {
					visited[graph[i][vertex]] = true;
					queue.add(graph[i][vertex]);
				}

			}

		}

		return false;
	}

	/**
	 * It adds a given road to the list. It also checks for duplicates.
	 * 
	 * @param the road to be added to the list
	 */

	public void addRoad(Road road) {
		for (Road r : roads) {
			if (r.equals(road)) {
				return;
			}
		}
		roads.add(road);

		for (Location l : locations.keySet()) {
			if (l.equals(road.getStartPoint())) {
				return;
			}
		}
		locations.put(road.getStartPoint(), locations.size());

		for (Location l : locations.keySet()) {
			if (l.equals(road.getFinishPoint())) {
				return;
			}
		}
		locations.put(road.getFinishPoint(), locations.size());

	}

}
