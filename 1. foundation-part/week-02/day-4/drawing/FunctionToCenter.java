import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
	public static void drawImage(Graphics graphics) {
		// Create a function that takes 3 parameters and draws a single line
		// Parameters: the x and y coordinates of the line's starting point and the graphics
		// The function shall draw a line from that point to the center of the canvas
		// Fill the canvas with lines from the edges (every 20 px) to the center
		int x = 0;
		int y = 0;
		for (int i = 0; i < 500; i+=20) {
			lineToCenter(x, y, graphics);
			x += 20;
		}

		for (int i = 0; i < 500; i+=20) {
			lineToCenter(x, y, graphics);
			y += 20;
		}

		for (int i = 0; i < 500; i+=20) {
			lineToCenter(x, y, graphics);
			x -= 20;
		}

		for (int i = 0; i < 500; i+=20) {
			lineToCenter(x, y, graphics);
			y -= 20;
		}



	}
	public static void lineToCenter(int startX, int startY, Graphics graphics) {
		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		graphics.drawLine(startX, startY, centerX, centerY);
	}

	// Don't touch the code below
	static int WIDTH = 500;
	static int HEIGHT = 500;

	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Drawing");
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImagePanel panel = new ImagePanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		jFrame.add(panel);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
		jFrame.pack();
	}

	static class ImagePanel extends JPanel {
		@Override
		protected void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			drawImage(graphics);
		}
	}
}