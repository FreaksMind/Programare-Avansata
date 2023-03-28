package lab6.compulsory;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	ConfigPanel configPanel;
	ControlPanel controlPanel;
	DrawingPanel canvas;

	public MainFrame() {
		super("My Drawing Application");
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		canvas = new DrawingPanel(this);
		configPanel = new ConfigPanel(this);
		controlPanel = new ControlPanel(this);
		add(canvas, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
		add(configPanel, BorderLayout.NORTH);
		pack();
	}
}