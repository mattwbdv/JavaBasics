
// Matt Koenig
// Monday Jan 7, 2019
// CS 211 Quiz 1

// THIS IS THE 
public class Pentagon implements Shape {
	private double Side;

	// default constructor
	public Pentagon() {
		super();
	}

	// constructor "setter" with double Side passed through
	public Pentagon(double newSide) {
		Side = newSide;
	}

	// getter for area WITHOUT ANY new side length passed through
	public double getArea() {
		return ((Math.sqrt((Math.sqrt(5) * 2 + 5) * 5)) * 0.25 * (Side * Side));
	}

	// getter for perimeter WITHOUT ANY new side length passed through
	public double getPerimeter() {
		return Side * 5;
	}

}
