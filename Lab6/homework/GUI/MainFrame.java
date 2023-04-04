package lab6.compulsory.GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import lab6.compulsory.Game.Game;

public class MainFrame extends JFrame {
	ConfigPanel configPanel;
	ControlPanel controlPanel;
	DrawingPanel canvas;
	Game game;

	public MainFrame(String p1, String p2) {
		super("Game");
		this.game = new Game(p1, p2, this);
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		controlPanel = new ControlPanel(this);
		configPanel = new ConfigPanel(this);
		canvas = new DrawingPanel(this);
		add(configPanel, BorderLayout.NORTH);
		add(controlPanel, BorderLayout.SOUTH);
		add(canvas, BorderLayout.CENTER);
		pack();
	}
}