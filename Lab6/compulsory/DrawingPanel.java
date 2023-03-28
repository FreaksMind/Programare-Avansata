package lab6.compulsory;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	final MainFrame frame;
	final static int W = 800, H = 600;

	public DrawingPanel(MainFrame frame) {
		this.frame = frame;
		initPanel();
	}

	private void initPanel() {
		setPreferredSize(new Dimension(W, H));
		setBorder(BorderFactory.createEtchedBorder());
	}

	@Override
	protected void paintComponent(Graphics g) {
		int centerX = this.getWidth() / 2;
        int centerY = this.getHeight() / 2;
        int numVertices = (int) frame.configPanel.dotsSpinner.getValue();
        int radius = Math.min(this.getWidth(), this.getHeight()) / 4;
        int[] x = new int[(int) numVertices];
        int[] y = new int[(int) numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = centerX + (int) (radius * Math.cos(2 * Math.PI * i / numVertices));
            y[i] = centerY + (int) (radius * Math.sin(2 * Math.PI * i / numVertices));
        }

        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }

        // Draw the edges
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                g.drawLine(x[i], y[i], x[j], y[j]);
            }
        }
        this.paintComponents(g);
	}
}
