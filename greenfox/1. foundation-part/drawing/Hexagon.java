import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

//AI PROMPT: create me a method in java that draws a
// regular hexagon (equal sides and angles)
public class Hexagon extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		int sideLength = 50; // Adjust the side length as needed

		// Calculate the coordinates of the six vertices
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];

		for (int i = 0; i < 6; i++) {
			double angle = 2 * Math.PI / 6 * i;
			xPoints[i] = (int) (centerX + sideLength * Math.cos(angle));
			yPoints[i] = (int) (centerY + sideLength * Math.sin(angle));
		}

		// Create a polygon and draw it
		Polygon hexagon = new Polygon(xPoints, yPoints, 6);
		g2d.draw(hexagon);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Regular Hexagon Drawer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 400);
			frame.add(new Hexagon());
			frame.setVisible(true);
		});
	}
}

// AI PROMPT: how would you calculate a height of a regular hexagon ?

// ANSWER: To calculate the height of a regular hexagon (the distance from one flat side to the opposite
// flat side), you can use the following formula:
//
// Height (h) = side length (s) × √3
//
// Here's an explanation of the formula:
//
// The height of a regular hexagon is the distance between any two parallel sides. It forms an equilateral
// triangle with two sides of the hexagon.
//
// The formula leverages the fact that the height of an equilateral triangle is given by h = s × √3/2,
// where "s" is the length of one of the triangle's sides.
//
// Since the height of the hexagon is twice the height of the equilateral triangle, we multiply the height
// of the equilateral triangle by 2, resulting in the formula Height = s × √3.
//
// So, to find the height of a regular hexagon, simply multiply the length of one of its sides
// by the square root of 3.