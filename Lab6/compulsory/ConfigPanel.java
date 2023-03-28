package lab6.compulsory;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfigPanel extends JPanel {
	final MainFrame frame;
	JLabel dotsLabel, linesLabel;
	JSpinner dotsSpinner;
	JComboBox linesCombo;
	JButton createButton;

	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		String probs[] = { "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" };

		dotsLabel = new JLabel("Number of dots:");
		dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
		linesLabel = new JLabel("Line probability:");
		createButton = new JButton("Create new game");
		createButton.addActionListener(this::createGame);
		linesCombo = new JComboBox(probs);

		add(dotsLabel);
		add(dotsSpinner);
		add(linesLabel);
		add(linesCombo);
		add(createButton);
	}

	private void createGame(ActionEvent e) {
		frame.repaint();
	}

}