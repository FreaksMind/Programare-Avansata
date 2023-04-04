package lab6.compulsory.Shape;

import java.awt.Color;

public class Line {

	private Vertex v1;
	private Vertex v2;
	private Color color;

	public Line() {
		
	}
	
	public Line(Vertex v1, Vertex v2) {
		color = Color.BLACK;
		this.v1 = v1;
		this.v2 = v2;
	}

	public Vertex getV1() {
		return v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Line)) {
			return false;
		}

		Line o = (Line) other;
		return (o.v1.getX() == v1.getX() && o.v1.getY() == v1.getY() && o.v2.getX() == v2.getX()
				&& o.v2.getY() == v2.getY());
	}
}
