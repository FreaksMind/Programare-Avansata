package lab6.compulsory.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lab6.compulsory.Game.Utils;
import lab6.compulsory.Shape.Line;
import lab6.compulsory.Shape.Vertex;

public class DrawingPanel extends JPanel {
	final MainFrame frame;
	final static int W = 800, H = 600;
	private int numVertices;
	private double edgeProbability;
	BufferedImage image; // the offscreen image
	Graphics2D graphics; // the tools needed to draw in the image
	List<Vertex> vertices = new ArrayList<>();

	public DrawingPanel(MainFrame frame) {
		this.frame = frame;
		createOffscreenImage();
		initPanel();
		createBoard();
	}

	private void initPanel() {
		setPreferredSize(new Dimension(W, H));
		setBorder(BorderFactory.createEtchedBorder());
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (frame.game.isRunning()) {
					for (Line l : frame.game.getLines()) {
						if (Line2D.ptLineDist(l.getV1().getX(), l.getV1().getY(), l.getV2().getX(), l.getV2().getY(),
								e.getX(), e.getY()) < 3) {
							if (l.getColor() != Color.RED && l.getColor() != Color.BLUE) {
								if (frame.game.getTurn()) {
									l.setColor(Color.BLUE);
									frame.game.getSecondPlayer().addMove(l);
									frame.game.changeTurn();
								} else {
									l.setColor(Color.RED);
									frame.game.getFirstPlayer().addMove(l);
									frame.game.changeTurn();
								}
							}
						}
					}
					if (frame.game.checkConditions() == 0) {
						System.out.printf("%s (RED) wins!", frame.game.getFirstPlayer().getName());
						Utils.print(image);
						frame.game.setRunning(false);
					} else if (frame.game.checkConditions() == 1) {
						frame.game.setRunning(false);
						Utils.print(image);
						System.out.printf("%s (BLUE) wins!", frame.game.getSecondPlayer().getName());
					} else if (frame.game.checkConditions() == 2) {
						frame.game.setRunning(false);
						System.out.println("Draw");
						Utils.print(image);
					} else {

					}
					repaint();
				}
			}
		});
	}

	private void createOffscreenImage() {
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 800, 600);
	}

	final void createBoard() {
		vertices.clear();
		frame.game.getLines().clear();
		frame.game.setTurn(false);
		frame.game.getFirstPlayer().getMoves().clear();
		frame.game.getSecondPlayer().getMoves().clear();
		numVertices = (int) this.frame.configPanel.dotsSpinner.getValue();
		edgeProbability = 1.0d;
		createOffscreenImage();
		createVertices();
		drawLines();
		drawVertices();
		repaint();
	}

//web
	private void createVertices() {
		int x0 = W / 2;
		int y0 = H / 2;
		int radius = H / 2 - 10;
		double alpha = 2 * Math.PI / numVertices;
		for (int i = 0; i < numVertices; i++) {
			Vertex v = new Vertex(x0 + (int) (radius * Math.cos(alpha * i)), y0 + (int) (radius * Math.sin(alpha * i)));
			vertices.add(v);
		}

		for (int i = 0; i < numVertices; i++) {
			for (int j = i + 1; j < numVertices; j++) {
				Line l = new Line(vertices.get(i), vertices.get(j));
				frame.game.addLine(l);
			}
		}
	}

	private void drawLines() {
		for (Line l : frame.game.getLines()) {
			graphics.setColor(l.getColor());
			graphics.drawLine(l.getV1().getX(), l.getV1().getY(), l.getV2().getX(), l.getV2().getY());
		}
	}

	private void drawVertices() {
		for (Vertex v : vertices) {
			graphics.setColor(v.getColor());
			graphics.drawOval(v.getX() - 5, v.getY() - 5, 10, 10);
		}
	}

	@Override
	public void update(Graphics g) {
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		drawLines();
		graphics.drawImage(image, 0, 0, this);
	}

	public void load() {
		numVertices = frame.game.getNumberVertices();
		graphics.setColor(Color.BLACK);
		createVertices();
		drawVertices();
		repaint();
	}

}