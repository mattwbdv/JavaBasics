
// Matt Koenig
// CS 210
// November 13, 2018
// Assignment #8A

import java.awt.*;
import java.lang.Math;

public final class Line {
	// **FIELDS**
	private Point p1;
	private Point p2;

	// **CONSTRUCTORS**
	// constructs line with provided points
	public Line(Point p1, Point p2) {
		this.p1 = new Point(p1);
		this.p2 = new Point(p2);
	}

	// constructs line at default (0, 0)
	public Line() {
		this.p1 = new Point();
		this.p2 = new Point();
	}

	// **METHODS**
	// gets first point
	public String getP1() {
		return ("[(" + this.p1.x + ", " + this.p1.y + ")]");
	}

	// gets line slope
	public double getSlope() {
		double slope = 0.0;
		if (p2.x - p1.x == 0) {
			throw new IllegalStateException();
		} else {
			slope = ((p2.y * 1.0 - p1.y) / (p2.x * 1.0 - p1.x));
		}
		return slope;

	}

	// gets line length
	public double getLength() {
		double length = 0.0;
		length = Math.sqrt((Math.pow((p2.x - p1.x), 2) + (Math.pow((p2.y - p1.y), 2))));
		return length;
	}

	// gets second point
	public String getP2() {
		return ("[(" + this.p2.x + ", " + this.p2.y + ")]");
	}

	// overrides toString to print points correctly
	public String toString() {
		return "[(" + this.p1.x + ",  " + this.p1.y + "), (" + this.p2.x + ",  " + this.p2.y + ")]";
	}

	// print method to print points in visually appealing way
	public String print() {
		return ("[(" + this.p1.x + ", " + this.p1.y + "), (" + this.p2.x + ", " + this.p2.y + ")]");
	}

	// plot method to draw lines using given points
	public void plot(Graphics gee) {
		gee.drawLine(p1.x, p1.y, p2.x, p2.y);

	}

	// uses line formula to evaluate for intersection using Cramer's rule
	public boolean intersect(Line other) {
		int otherSlope = ((other.p2.y - other.p1.y) / (other.p2.x - other.p1.x));
		int thisSlope = ((this.p2.y - this.p1.y) / (this.p2.x - this.p1.x));
		int otherYIntercept = other.p1.y - (otherSlope * other.p1.x);
		int thisYIntercept = this.p1.y - (thisSlope * this.p1.x);
		int xIntersection = (otherYIntercept - thisYIntercept) / (thisSlope - otherSlope);
		int yIntersection = (otherYIntercept * thisSlope - thisYIntercept * otherSlope) / (thisSlope - otherSlope);

		// if intersection point is within passed line segment X values then true (it
		// must be present on this line)
		if ((other.p2.x <= xIntersection && xIntersection <= other.p1.x && yIntersection == otherSlope * xIntersection + otherYIntercept)
				|| (other.p2.x >= xIntersection && xIntersection >= other.p1.x && yIntersection == otherSlope * xIntersection + otherYIntercept)) {
			return true;

		} else {
			return false;
		}

	}

}