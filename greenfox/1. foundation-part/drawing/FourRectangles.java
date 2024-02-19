import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.util.Random;

public class FourRectangles {

	public static void drawImage(Graphics graphics){
		// Draw four different size and color rectangles
		// Avoid code duplication!

		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int colorA = random.nextInt(255);
			int colorB = random.nextInt(255);
			int colorC = random.nextInt(255);
			graphics.setColor(new Color(colorA, colorB, colorC));

			int startX = random.nextInt(400);
			int startY = random.nextInt(400);
			int sizeA = random.nextInt(80) + 20;
			int sizeB = random.nextInt(80) + 20;
			graphics.fillRect(startX, startY, sizeA, sizeB);
		}

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