// Matt Koenig
// CS 210
// November 16, 2018
// Quiz 8

import java.awt.Point;
//import java.util.*;

public class Hexagon {

	// **FIELDS**
	private Point center;
	private double side;

	// **CONSTRUCTORS**
	public Hexagon() {
		this(new Point(0, 0), 0);
	}

	public Hexagon(Point c, double s) {
		center = c;
		side = s;
	}

	// Gets Point center
	public Point getCenter() {
		return center;

	}

	// Gets side length
	public double getSide() {
		return side;
	}

	// Sets new center of Point c
	public void setCenter(Point c) {
		center = c;
	}

	// Sets new side length of type double
	public void setSide(double r) {
		side = r;
	}

	// **METHODS**
	// Gets area of a hexagon
	public double area() {
		double area = ((3 * (Math.sqrt(3))) / 2) * (side * side);
		return area;
	}

	// Gets perimeter of a hexagon
	public double perimeter() {
		double perimeter = side * 6;
		return perimeter;
	}
}
