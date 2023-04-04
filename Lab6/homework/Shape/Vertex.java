package lab6.compulsory.Shape;

import java.awt.Color;

public class Vertex {

	private int x;
	private int y;
	private Color color;

	public Vertex() {
		
	}
	
	public Vertex(int x, int y) {
		color = Color.BLACK;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
}
