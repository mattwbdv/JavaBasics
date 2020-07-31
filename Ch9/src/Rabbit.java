import java.awt.Color;
// Matt Koenig
// Jan 2, 2019
// CS 211

public class Rabbit implements Animal {
	private int steps = 1;
	private int tempDirection;

	// constructor
	public Rabbit() {
		super();
	}

	public String toString() {
		return "V";
	}

	// logic behind directional movement
	public int getMove(AnimalInfo info) {

		// there are six possible movement components, broken down into three directions
		if (steps % 6 == 1 | steps % 6 == 2)
			tempDirection = NORTH;
		else if (steps % 6 == 3 | steps % 6 == 4)
			tempDirection = EAST;
		else if (steps % 6 == 5 | steps % 6 == 0)
			tempDirection = SOUTH;

		steps++;
		return tempDirection;
	}

	// white for rabbit
	public Color getColor() {
		return new Color(255, 255, 255);
	}

}
