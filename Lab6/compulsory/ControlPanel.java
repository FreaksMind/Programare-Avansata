package lab6.compulsory;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	final MainFrame frame;
	JButton exitBtn = new JButton("Exit");
	JButton loadBtn = new JButton("Load");
	JButton saveBtn = new JButton("Save");
	JButton resetBtn = new JButton("Reset");

	public ControlPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		setLayout(new GridLayout(1, 4));

		add(loadBtn);
		add(saveBtn);
		add(resetBtn);
		add(exitBtn);

		exitBtn.addActionListener(this::exitGame);
		loadBtn.addActionListener(this::loadGame);
		saveBtn.addActionListener(this::saveGame);
		resetBtn.addActionListener(this::resetGame);
	}

	private void exitGame(ActionEvent e) {
		frame.dispose();
	}

	private void loadGame(ActionEvent e) {
	}

	private void resetGame(ActionEvent e) {
	}

	private void saveGame(ActionEvent e) {
	}
}