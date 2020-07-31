// Matt Koenig
// BC | CS 210
// October 26, 2018
// Quiz 3G

import java.awt.*;

public class Quiz3G {
	public static void main(String[] args) {
		showOrbital(200, 600);
		showOrbital(600, 600);
		showOrbital(600, 200);

	}

		// This prints concentric circles that are respective of the given pane's width and height 
		public static void showOrbital(int x, int y) {
			// Drawing panel file is required for this problem
			DrawingPanel panel = new DrawingPanel(x, y);
			panel.setBackground(Color.red);
			Graphics g = panel.getGraphics();
			
			// class constants
			int xLength = x; 
			int yLength = y;
			
			for (int i = 4; i > 0; i--) { // for loop for number of circles
				
				if (i % 2 == 1) { // if statement to determine color
					g.setColor(Color.white);
				} else {
					g.setColor(Color.black);
				}
				
				g.fillOval(x - xLength, y - yLength, xLength, yLength); // logic for concentric circles
				xLength /= 2;
				yLength /= 2;
				x = x - (xLength / 2);
				y = y - (yLength / 2);
			}

	}
}
