package lab6.compulsory.Game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import lab6.compulsory.GUI.MainFrame;
import lab6.compulsory.Shape.Line;

public class Game {

	MainFrame frame;
	private Player player1;
	private Player player2;
	private List<Line> lines = new ArrayList<>();
	private boolean turn = false; // first player - red
	private boolean running = true;
	private int number_vertices;

	public Game() {
		
	}
	
	public Game(String p1, String p2, MainFrame frame) {
		number_vertices = 0;
		player1 = new Player(p1);
		player2 = new Player(p2);

		player1.setColor(Color.RED);
		player2.setColor(Color.BLUE);

		this.frame = frame;

		System.out.printf("Game between %s (%s) and %s (%s) started!", player1.getName(), player1.getColor(),
				player2.getName(), player2.getColor());
	}

	public List<Line> getLines() {
		return lines;
	}

	public void addLine(Line l) {
		lines.add(l);
	}

	public void reset() {
		lines.clear();
		frame.repaint();
	}

	public Player getFirstPlayer() {
		return player1;
	}

	public Player getSecondPlayer() {
		return player2;
	}

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = false;
	}

	public void changeTurn() {
		turn = !turn;
	}

	public int checkConditions() {
		if (lines.size() == player1.getMoves().size() + player2.getMoves().size())
			return 2;
		for (Line l1 : player1.getMoves()) {
			for (Line l2 : player1.getMoves()) {
				for (Line l3 : player1.getMoves()) {
					if (l1.equals(l2) || l1.equals(l3) || l2.equals(l3))
						continue;
					if (Utils.checkIntersection(l1, l2) && Utils.checkIntersection(l1, l3)
							&& Utils.checkIntersection(l2, l3))
						return 0;
				}
			}
		}
		for (Line l1 : player2.getMoves()) {
			for (Line l2 : player2.getMoves()) {
				for (Line l3 : player2.getMoves()) {
					if (l1.equals(l2) || l1.equals(l3) || l2.equals(l3))
						continue;
					if (Utils.checkIntersection(l1, l2) && Utils.checkIntersection(l1, l3)
							&& Utils.checkIntersection(l2, l3))
						return 1;
				}
			}
		}
		return -1;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getNumberVertices() {
		return number_vertices;
	}

	public void setNumberVertices(int number_vertices) {
		this.number_vertices = number_vertices;
	}
}
