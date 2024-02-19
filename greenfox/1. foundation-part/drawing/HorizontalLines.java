import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
	public static void drawImage(Graphics graphics) {
		// Create a function that takes 3 parameters and draws a single line
		// Parameters: the x and y coordinates of the line's starting point and the graphics
		// The function shall draw a 50-pixel long horizontal line from that point
		// Draw at least 3 lines with that function using a loop

		Random random = new Random();
		int i = 3;
		while (i <= random.nextInt(10) + 3) {
			int startX = random.nextInt(450);
			int startY = random.nextInt(450);
			drawHorizontal(startX, startY, graphics);
			i++;
		}

		}
		public static void drawHorizontal(int startX, int startY, Graphics graphics) {
			int newX = startX + 50;
			graphics.drawLine(startX, startY, newX, startY);
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