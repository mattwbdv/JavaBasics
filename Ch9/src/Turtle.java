import java.awt.Color;
// Matt Koenig
// Jan 2, 2019
// CS 211

public class Turtle implements Animal {
	private int steps = 1;
	private int tempDirection;

	// constructor
	public Turtle() {
		super();
	}

	public String toString() {
		return "T";
	}

	// logic behind directional movement
	public int getMove(AnimalInfo info) {

		// twenty possible movement components broken down into four possible directions
		if (steps % 20 == 1 | steps % 20 == 2 | steps % 20 == 3 | steps % 20 == 4 | steps % 20 == 5)
			tempDirection = SOUTH;
		else if (steps % 20 == 6 | steps % 20 == 7 | steps % 20 == 8 | steps % 20 == 9 | steps % 20 == 10)
			tempDirection = WEST;
		else if (steps % 20 == 11 | steps % 20 == 12 | steps % 20 == 13 | steps % 20 == 14 | steps % 20 == 15)
			tempDirection = NORTH;
		else if (steps % 20 == 16 | steps % 20 == 17 | steps % 20 == 18 | steps % 20 == 19 | steps % 20 == 0)
			tempDirection = EAST;

		steps++;
		return tempDirection;
	}

	// dark green for turtle
	public Color getColor() {
		return new Color(0, 100, 0);
	}

}
