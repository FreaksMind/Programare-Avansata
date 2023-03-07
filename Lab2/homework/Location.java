package lab2.homework;

public class Location {
	// Al shrafat Maroan
	private String name;
	private int x;
	private int y;

	public Location() {
	}

	public Location(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter for name variable
	 * 
	 * @return the name of the location
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name variable
	 * 
	 * @param name the name of the location to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for x coordinate
	 * 
	 * @return the x-axis coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * Setter for x variable
	 * 
	 * @param the coordinate of the x-axis
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter for y coordinate
	 * 
	 * @return the y-axis coordinate
	 */
	public float getY() {
		return y;
	}

	/**
	 * Setter for y variable
	 * 
	 * @param the coordinate of the y-axis
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns whether the current object is equal to other object based on their name and coordinates
	 * 
	 * @param the other object to be compared to
	 * @return a boolean indicating the equality of the objects
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Location))
			return false;

		Location otherLocation = (Location) obj;
		return (this.name.equals(otherLocation.name) && this.x == otherLocation.x && this.y == otherLocation.y);

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
