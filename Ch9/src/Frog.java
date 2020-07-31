import java.awt.Color;
// Matt Koenig
// Jan 2, 2019
// CS 211

public class Frog implements Animal {
	private int steps = 0;
	private int tempDirection;

	// constructor
	public Frog() {
		super();
	}

	public String toString() {
		return "F";
	}

	// logic behind directional movement
	public int getMove(AnimalInfo info) {

		// after three moves in one direction it re-sets to a new direction out of the
		// four possibilities
		if (steps % 3 == 0) {
			double r = Math.random();
			if (r < 0.25)
				tempDirection = NORTH;
			else if (r < 0.5)
				tempDirection = SOUTH;
			else if (r < 0.75)
				tempDirection = EAST;
			else
				tempDirection = WEST;
		}
		steps++;
		return tempDirection;
	}

	// light green for frog
	public Color getColor() {
		return new Color(0, 255, 0);
	}

}
