package lab2.homework;

public class Road {
	// Al shrafat Maroan
	private String name;
	private int length;
	private int speedLimit;
	private Location startPoint;
	private Location finishPoint;

	public Road() {
	}

	public Road(String name, Location startPoint, Location finishPoint) {
		if (startPoint.equals(finishPoint)) {
			System.out.println("You can have a road with same start and finish points!");
			System.exit(-1);
		}
		this.name = name;
		this.startPoint = startPoint;
		this.finishPoint = finishPoint;

	}

	/**
	 * Getter for the name of the road
	 * 
	 * @return the name of the road
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the name of the road
	 * 
	 * @param name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the length of the road
	 * 
	 * @return the length of the road
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Setter for the length of the road. It checks if the length is valid based on
	 * the coordinates of the locations
	 * 
	 * @param length to be set
	 */
	public void setLength(int length) {
		int euclidianDistance = (int) Math.sqrt(Math.pow(this.finishPoint.getX() - this.startPoint.getX(), 2)
				+ Math.pow(this.finishPoint.getY() - this.startPoint.getX(), 2));
		if (length < euclidianDistance) {

			System.out.printf(
					"(Road %s) The length of a road should not be less than the euclidian distance between the location coordinates.",
					this.name);
		} else {
			this.length = length;
		}
	}

	/**
	 * Getter for speedLimit
	 * 
	 * @return the speedLimit of the road
	 */

	public int getSpeedLimit() {
		return speedLimit;
	}

	/**
	 * Setter for name variable
	 * 
	 * @param name the name of the location to be set
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	/**
	 * Getter for startPoint
	 * 
	 * @return the first point of the road
	 */

	public Location getStartPoint() {
		return startPoint;
	}

	/**
	 * Setter for first point of the road
	 * 
	 * @param Location to be set
	 */
	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Getter for finishPoint
	 * 
	 * @return the second point of the road
	 */

	public Location getFinishPoint() {
		return finishPoint;
	}

	/**
	 * Setter for second point of the road
	 * 
	 * @param Location to be set
	 */
	public void setFinishPoint(Location finishPoint) {
		this.finishPoint = finishPoint;
	}

	/**
	 * Returns whether the current object is equal to other object based on their
	 * name and points
	 * 
	 * @param the other object to be compared to
	 * @return a boolean indicating the equality of the objects
	 */

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Road))
			return false;

		Road otherRoad = (Road) obj;
		return (this.name.equals(otherRoad.name) && this.startPoint.equals(otherRoad.startPoint)
				&& this.finishPoint.equals(otherRoad.finishPoint));

	}

	/**
	 * Returns a textual representation of the object
	 * 
	 * @return a string that represents the object as text
	 */

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		return sb.toString();

	}
}
