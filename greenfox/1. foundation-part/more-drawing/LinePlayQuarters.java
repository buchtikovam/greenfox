import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
	public static void drawImage(Graphics graphics) {
		int myWidth = WIDTH;
		int myHeight = HEIGHT;

		//divide canvas into 4 parts
		int sectionWidth = myWidth / 2;
		int sectionHeight = myHeight / 2;

		graphics.drawLine(sectionWidth, 0, sectionWidth, myHeight);
		graphics.drawLine(0, sectionHeight, myWidth, sectionHeight);

		int startX = sectionWidth;
		int startY = sectionHeight;
		int endX = 0;
		int endY = sectionHeight;
		int difference = sectionHeight / 15;

		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < 2; j++) {
				startX = j * sectionWidth;
				for (int k = 0; k < 14; k++) {
					startX -= difference;
					endY -= difference;
					graphics.setColor(Color.green);
					graphics.drawLine(startX, startY, endX, endY);
				}

			}
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