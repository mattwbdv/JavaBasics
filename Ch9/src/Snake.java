import java.awt.Color;
// Matt Koenig
// Jan 2, 2019
// CS 211

public class Snake implements Animal {
	private int steps = 0;
	private int horizDirection = 0;
	private int tempDirection;

	// constructor
	public Snake() {
		super();
	}

	public String toString() {
		return "S";
	}

	// logic behind directional movement
	public int getMove(AnimalInfo info) {
		// starts by incrementing step
		steps++;

		// goes down once step counter surpasses directional movement quota
		if (steps > horizDirection) {
			steps = 0;
			horizDirection++;
			tempDirection = SOUTH;

			// this component of the logic accounts for either east or west movement
		} else if (horizDirection % 2 == 0) {
			tempDirection = EAST;
		} else if (horizDirection % 2 == 1) {
			tempDirection = WEST;
		}

		// returns the direction
		return tempDirection;

	}

	// black for snake
	public Color getColor() {
		return new Color(0, 0, 0);
	}

}
