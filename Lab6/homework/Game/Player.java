package lab6.compulsory.Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import lab6.compulsory.Shape.Line;

public class Player {

	private String name;
	private List<Line> moves = new ArrayList<>();
	private Color color;

	public Player() {
		
	}
	
	public Player(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void addMove(Line l) {
		moves.add(l);
	}

	public List<Line> getMoves() {
		return moves;
	}

}
