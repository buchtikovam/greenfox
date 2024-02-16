import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Diagonals {
	public static void drawImage(Graphics graphics) {
		// Create a function that draws a single line
		// Use this function to draw the canvas' diagonals
		// If the line starts from the upper-left corner it should be green, otherwise it should be red
		// Make decision about the color in the function
		drawDiagonal(0, 0, WIDTH, HEIGHT, graphics);
		drawDiagonal(0, HEIGHT, WIDTH, 0, graphics);
	}


	public static void drawDiagonal(int startX, int startY, int endX, int endY, Graphics graphics) {
		if (startX == 0 && startY == 0) {
			graphics.setColor(Color.green);
		} else {
			graphics.setColor(Color.red);
		}
		graphics.drawLine(startX, startY, endX, endY);
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
