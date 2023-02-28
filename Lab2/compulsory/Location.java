package lab2.compulsory;

public class Location {
	// Al shrafat Maroan
	private String name;
	private LocationType type;
	private float x;
	private float y;

	public Location() {
		this.type = LocationType.UNKNOWN;
	}

	public Location(String name, float x, float y, LocationType type) {
		this.name = name;
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocationType getType() {
		return type;
	}

	public void setType(LocationType type) {
		this.type = type;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Location))
			return false;

		Location otherLocation = (Location) obj;
		return (this.name.equals(otherLocation.name) && this.x == otherLocation.x && this.y == otherLocation.y);

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("Location ").append(this.name).append("(").append(this.type).append(") located at: (").append(this.x)
				.append(", ").append(this.y).append(")");
		return sb.toString();

	}

}
