package lab2.compulsory;

public class Main {
	// Al shrafat Maroan
	public static void main(String[] args) {
		Location cityIasi = new Location("Iasi", 23, 42, LocationType.CITY);
		Location cityCluj = new Location("Cluj", 23, 42, LocationType.CITY);
		System.out.println(cityIasi.toString());
		Road road = new Road("Salut", RoadType.COUNTRY, cityIasi, cityCluj);
		System.out.println(road.toString());
	
	}

}
