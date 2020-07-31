import java.awt.Color;
// Matt Koenig
// Jan 2, 2019
// CS 211

public class Wolf implements Animal {

	// constructor
	public Wolf() {
		super();
	}

	public String toString() {
		return "W";
	}

	// logic behind directional movement
	public int getMove(AnimalInfo info) {

		// designed to mostly move north east with rare western movement
		double r = Math.random();
		if (r < 0.5)
			return NORTH;
		if (r > 0.5 && r < 0.95)
			return EAST;
		else
			return WEST;

	}

	// grey for wolf
	public Color getColor() {
		return new Color(211, 211, 211);
	}

}
