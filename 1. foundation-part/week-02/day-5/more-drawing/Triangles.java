import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
	public static void drawImage(Graphics graphics) {
		int triangleCount = 21;
		int triangleSize = WIDTH / triangleCount;
		int triangleHeight = (int) Math.round((Math.sqrt(3) / 2) * triangleSize);

		for (int yTriangles = 0; yTriangles < triangleCount; yTriangles++) {
			for (int xTriangles = 0; xTriangles < triangleCount - yTriangles; xTriangles++) {
				int x1 = (xTriangles * triangleSize) + (yTriangles * (triangleSize / 2));
				int y1 = HEIGHT - (yTriangles * triangleHeight);
				int x2 = ((xTriangles + 1) * triangleSize) + (yTriangles * (triangleSize / 2));
				int y2 = y1;
				int x3 = (((xTriangles + 1) * triangleSize) - (triangleSize / 2)) + (yTriangles * (triangleSize / 2));
				int y3 = HEIGHT - ((yTriangles + 1) * triangleHeight);
				int[] x = {x1, x2, x3};
				int[] y = {y1, y2, y3};
				graphics.drawPolygon(x, y, 3);
			}
		}

	}




	// Don't touch the code below
	static int WIDTH = 420;
	static int HEIGHT = WIDTH;

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