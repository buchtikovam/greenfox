import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlay {
	public static void drawImage(Graphics graphics){
		int myWidth = WIDTH - 5; // border so lines do not start from the edge
		int myHeight = HEIGHT - 5;

		//divide canvas into 15 parts
		int divWidth = myWidth / 15;
		int divHeight = myHeight / 15;

		//changing variable values for bottom loop
		int startX = myWidth;
		int startY = myHeight;
		int endX = 5;
		int endY = myHeight;

		for (int i = 0; i < 14; i++) {
			startX -= divWidth;
			endY -= divHeight;
			graphics.setColor(Color.green);
			graphics.drawLine(startX, startY, endX, endY);
		}

		//changing variable values for top loop
		startX = myWidth;
		endX = myWidth;
		endY = 5;

		for (int i = 0; i < 14; i++) {
			startY -= divHeight;
			endX -= divWidth;
			graphics.setColor(new Color(0x800080));
			graphics.drawLine(startX, startY, endX, endY);
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