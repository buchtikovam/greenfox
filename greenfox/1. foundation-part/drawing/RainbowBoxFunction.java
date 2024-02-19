import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
	public static void drawImage(Graphics graphics) {
		// Create a square drawing function that takes 3 parameters
		// (the square size, the fill color and the graphics)
		// and draws a square of that size and color to the center of the canvas.
		// Create a loop that fills the canvas with rainbow colored squares (red, orange, yellow, green, blue, indigo, violet).

		Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(0x4b0082),new Color(0x800080)};
		int size = 70;

		for (int i = 0; i < colors.length; i++) {
			drawSquare(size, colors[i], graphics);
			size = size + 20;
		}
	}
	public static void drawSquare(int size, Color color, Graphics graphics) {
		int centerX = WIDTH / 2;
		int centerY = HEIGHT / 2;
		int x = centerX - size / 2;
		int y = centerY - size / 2;
		graphics.setColor(color);
		graphics.drawRect(x, y, size, size);
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