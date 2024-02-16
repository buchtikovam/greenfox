import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.Random;
public class StarryNight {
	public static void drawImage(Graphics graphics) {
		// Draw the night sky:
		//  - The background should be black
		//  - The stars can be small squares
		//  - The stars should have random positions on the canvas
		//  - The stars should have random color (some shade of grey)
		Random random = new Random();
		
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		int x, y, size = 0;

		for (int i = 0; i < 250; i++) {
			x = random.nextInt(500);
			y = random.nextInt(500);
			size = random.nextInt(5) + 1;
			graphics.setColor(Color.gray);
			graphics.fillRect(x, y, size, size);

			x = random.nextInt(500);
			y = random.nextInt(500);
			size = random.nextInt(5) + 1;
			graphics.setColor(Color.lightGray);
			graphics.fillRect(x, y, size, size);
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