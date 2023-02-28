package lab2.compulsory;

public class Road {
	// Al shrafat Maroan
	private String name;
	private RoadType type;
	private int length;
	private int speedLimit;
	private Location startPoint;
	private Location finishPoint;

	public Road() {
		this.type = RoadType.UNKNOWN;
	}

	public Road(String name, RoadType type, Location startPoint, Location finishPoint) {
		this.name = name;
		this.type = type;
		this.startPoint = startPoint;
		this.finishPoint = finishPoint;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoadType getType() {
		return type;
	}

	public void setType(RoadType type) {
		this.type = type;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		int euclidianDistance = (int) Math.sqrt(Math.pow(this.finishPoint.getX() - this.startPoint.getX(), 2)
				+ Math.pow(this.finishPoint.getY() - this.startPoint.getX(), 2));
		if (length < euclidianDistance) {
			System.out.println(
					"The length of a road should not be less than the euclidian distance between the location coordinates.");
		} else {
			this.length = length;
		}
	}

	public int getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Location getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Location startPoint) {
		this.startPoint = startPoint;
	}

	public Location getFinishPoint() {
		return finishPoint;
	}

	public void setFinishPoint(Location finishPoint) {
		this.finishPoint = finishPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Road))
			return false;

		Road otherRoad = (Road) obj;
		return (this.name.equals(otherRoad.name) && this.startPoint == otherRoad.startPoint
				&& this.finishPoint == otherRoad.finishPoint);

	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Road ").append(this.name).append("(").append(this.type).append(") between ")
				.append(this.startPoint.toString()).append(" and ").append(this.finishPoint.toString());

		return sb.toString();

	}
}
