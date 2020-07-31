import java.awt.*;

public class GraphicsPractice {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(200, 200);
		//panel.setBackground(Color.yellow);
		Graphics g = panel.getGraphics();

		// drawFigure(g, 50, 25);
		// drawFigure(g, 250, 45);

		// drawFace(g, 10, 30);
		// drawFace(g, 150, 50);
		
		ShowDesign(g, 80, 80);

		
	}

	public static void drawFigure(Graphics g, int x, int y) {
		g.setColor(Color.blue);
		g.fillOval(x, y, 40, 40);
		g.fillOval(x + 80, y, 40, 40);
		g.setColor(Color.red);
		g.fillRect(x + 20, y + 20, 80, 80);
		g.setColor(Color.black);
		g.drawLine(x + 20, y + 60, x + 100, y + 60);

	}

	public static void drawFace(Graphics g, int xCoordinate, int yCoordinate) {

		g.setColor(Color.BLACK);
		g.drawOval(xCoordinate, yCoordinate, 100, 100); // face outline

		g.setColor(Color.BLUE);
		g.fillOval(xCoordinate + 20, yCoordinate + 30, 20, 20); // eyes
		g.fillOval(xCoordinate + 60, yCoordinate + 30, 20, 20);

		g.setColor(Color.RED); // mouth
		g.drawLine(xCoordinate + 30, yCoordinate + 70, xCoordinate + 70, yCoordinate + 70);

	}
	
	
	public static void ShowDesign(Graphics g, int x, int y) {
		int length = 40;
		for (int i = 4; i > 0; i--) {
			g.drawRect(x, y, length, length);
			length += 40;
			x -= 20; 
			y -= 20;
		}
		
	}
}
