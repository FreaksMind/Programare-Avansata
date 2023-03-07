package lab2.homework;

import lab2.homework.locations.Airport;
import lab2.homework.locations.City;

public class Main {
	// Al shrafat Maroan
	public static void main(String[] args) {
		Airport airport0 = new Airport("a", 385, 25);
		Airport airport1 = new Airport("b", 35, 35);
		Airport airport2 = new Airport("c", 643, 835);
		Airport airport3 = new Airport("d", 434, 253);
		City city1 = new City("c", 356, 236);
		City city2 = new City("d", 934, 253);

		Road r = new Road("Arcu", airport0, airport1);

		Road r2 = new Road("DN23", airport3, airport2);
		Road r3 = new Road("DN63", airport2, city2);

		Problem p = new Problem();

		p.addRoad(r);
		p.addRoad(r2);

		System.out.println(p.solve(airport0, airport1) ? "Exista drum" : "Nu exista drum");
	}

}
