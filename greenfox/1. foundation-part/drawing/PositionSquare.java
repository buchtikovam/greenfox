import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.Random;
public class PositionSquare {

	public static void drawImage(Graphics graphics){
		// Create a function that takes 3 parameters and draws one square
		// Parameters: the x and y coordinates of the square's top left corner and the graphics
		// The function shall draw a 50x50 square from that point
		// Draw 3 squares with that function
		// Avoid code duplication!
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			int startX = random.nextInt(450);
			int startY = random.nextInt(450);
			drawSquare(startX, startY, 50, 50, graphics);
		}
	}
	public static void drawSquare(int x, int y, int width, int height, Graphics graphics) {
		graphics.setColor(Color.pink);
		graphics.fillRect(x, y, width, height);
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