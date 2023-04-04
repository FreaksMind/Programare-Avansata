package lab6.compulsory.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import lab6.compulsory.Game.Game;

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
		try {
			ObjectMapper mapper = new ObjectMapper();
			Game game = mapper.readValue(new File("./game.json"), Game.class);
			frame.game = game;
			frame.canvas.load();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void resetGame(ActionEvent e) {
		frame.canvas.createBoard();
		frame.game.setRunning(true);
	}

	private void saveGame(ActionEvent e) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File("./game.json"), frame.game);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}