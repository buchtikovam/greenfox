import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EnvelopeStar {
	public static void drawImage(Graphics graphics){
		int middleX = WIDTH / 2;
		int middleY = HEIGHT / 2;

		//divide canvas into 32 parts
		int divWidth = WIDTH / 32;
		int divHeight = HEIGHT / 32;

		graphics.setColor(Color.green);

		//creating top left loop
		int startX = 0;
		int startY = middleY;
		int endX = middleX;
		int endY = middleY;

		for (int i = 0; i < 15; i++) {
			startX += divWidth;
			endY -= divHeight;
			graphics.drawLine(startX, startY, endX, endY);
		}

		//creating bottom left loop
		startX = 0;
		endY = middleY;

		for (int i = 0; i < 15; i++) {
			startX += divWidth;
			endY += divHeight;
			graphics.drawLine(startX, startY, endX, endY);
		}

		//creating top right loop
		startX = WIDTH;
		endY = middleY;

		for (int i = 0; i < 15; i++) {
			startX -= divWidth;
			endY -= divHeight;
			graphics.drawLine(startX, startY, endX, endY);
		}

		//creating bottom right loop
		startX = WIDTH;
		endY = middleY;

		for (int i = 0; i < 15; i++) {
			startX -= divWidth;
			endY += divHeight;
			graphics.drawLine(startX, startY, endX, endY);
		}

		graphics.drawLine(middleX, divHeight, middleX, HEIGHT - divHeight);
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