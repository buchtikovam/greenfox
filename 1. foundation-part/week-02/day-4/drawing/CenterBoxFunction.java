import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.Random;
public class CenterBoxFunction {

	public static void drawImage(Graphics graphics){
		// Create a function that takes 2 parameters and draws one square
		// Parameters: the square size and the graphics
		// The function shall draw a square of that size to the center of the canvas
		// Draw 3 squares with that function
		// (the squares should not be filled otherwise they will hide each other)
		// Avoid code duplication!

		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int size = random.nextInt(460) + 30;
			drawCenteredSquare(size, graphics);
		}
	}
	public static void drawCenteredSquare(int size, Graphics graphics) {
		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		int startX = centerX - size / 2;
		int startY = centerY - size / 2;
		graphics.setColor(Color.pink);
		graphics.drawRect(startX, startY, size, size);
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