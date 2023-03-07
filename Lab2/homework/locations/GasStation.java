package lab2.homework.locations;

import lab2.homework.Location;

public class GasStation extends Location {

	private float gasPrice;
	private int fuelCapacity;
	private int remainingFuel;
	
	public GasStation(String name, int x, int y) {
		super(name, x, y);
	}

	public float getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(float gasPrice) {
		this.gasPrice = gasPrice;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public int getRemainingFuel() {
		return remainingFuel;
	}

	public void setRemainingFuel(int remainingFuel) {
		this.remainingFuel = remainingFuel;
	}
	
	

}
