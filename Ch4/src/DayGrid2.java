
// Matt Koenig
// CS 210
// October 9, 2018
// Coding Assignment 4 

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

// This program takes month and year both of type int and prints a calendar that accurately accounts for leap 
// years between 1900-2100
public class DayGrid2 {
	public static void main(String[] args) {
		int month = 8;
		int year = 2017;
		DrawingPanel panel = new DrawingPanel(400, 200);
		Graphics g = panel.getGraphics();
		showGrid(g, month, year); // Assignment #2
		showGrid(month, year); // Assignment #1

	}

	// This method is overloaded and requires a graphics parameter. It accounts for
	// leap years and builds its own calendar using the graphics functionality in
	// Java.

	public static void showGrid(Graphics g, int month, int year) {

		// Top line of calendar with dates drawn
		g.drawString("Sun", 20, 20);
		g.drawString("Mon", 60, 20);
		g.drawString("Tue", 100, 20);
		g.drawString("Wed", 140, 20);
		g.drawString("Thur", 180, 20);
		g.drawString("Fri", 220, 20);
		g.drawString("Sat", 260, 20);
		g.drawRect(10, 25, 280, 125);

		// Class constants
		int x = 10;
		int y = 25;
		GregorianCalendar tempCal = new GregorianCalendar(year, month - 1, 1);
		int firstDay = tempCal.get(Calendar.DAY_OF_WEEK);
		int xPosition = -20;
		int yPosition = 40;
		int date = 1;

		// Draws calendar skeleton
		for (int rows = 0; rows < 5; rows++) {
			for (int columns = 0; columns < 7; columns++) {
				g.drawRect(x, y, 40, 25);
				x += 40;
			}
			x = 10;
			y += 25;
		}

		// Solves leap-year problem by altering class constant daysInMonth
		int daysInMonth;
		if (year % 4 == 0 && month - 1 == 1) {
			daysInMonth = 29;
		} else {
			daysInMonth = daysInMonth(month);
		}

		// Blank spaces at beginning of month
		for (int j = 0; j <= firstDay - 1; j++) {
			xPosition += 40;
		}

		// all numbered days within month
		for (int m = 0; m < daysInMonth; m++) {
			if (xPosition == 260 && yPosition != 140) {
				g.drawString(String.valueOf(date), xPosition, yPosition);
				yPosition += 25;
				xPosition = 20;
				date++;
			}
			if (date <= daysInMonth) {
				g.drawString(String.valueOf(date), xPosition, yPosition);
				xPosition += 40;
				date++;
			} else {
			}

		}

	}

	// This method accounts for leap years, passing through month, year, and number
	// of days in month to the calendar builder. It also calls header and footer
	// design methods

	public static void showGrid(int month, int year) {
		int daysInMonth;
		if (year % 4 == 0 && month - 1 == 1) {
			daysInMonth = 29;
		} else {
			daysInMonth = daysInMonth(month);
		}

		header();
		buildCalendar(month, year, daysInMonth);
		footer();
	}

	// This method actually builds the calendar
	public static void buildCalendar(int month, int year, int daysInMonth) {
		GregorianCalendar tempCal = new GregorianCalendar(year, month - 1, 1);
		int firstDay = tempCal.get(Calendar.DAY_OF_WEEK);
		int position = 1;
		int date = 1;
		System.out.print("|");

		// blank spaces before month starts
		for (int j = position; j <= firstDay - 1; j++) {
			System.out.printf("%3s", "");
			System.out.printf("%3s", "|");
			position++;
		}

		// all numbered days within month
		for (int m = 0; m < daysInMonth; m++) {
			if (position % 7 == 0) {
				System.out.printf("%3d", date);
				System.out.printf("%3s", "|");
				System.out.println("");
				System.out.print("|");
				date++;
				position++;
			}
			if (date <= daysInMonth) {
				System.out.printf("%3d", date);
				System.out.printf("%3s", "|");
				date++;
				position++;
			}
			if (date > daysInMonth) {

				// blank spaces after month ends
				for (int d = position; d <= 35; d++) {
					if (position == 35) {
						System.out.printf("%3s", "");
						System.out.printf("%3s", "|");
						position++;
					} else {
						System.out.printf("%3s", "");
						System.out.printf("%3s", "|");
						position++;
					}
				}
			}

		}
		System.out.println("");

	}

	// determines number of days in a month
	public static int daysInMonth(int month) {
		if (month == 1) {
			return 31;
		}
		if (month == 2) {
			return 28;
		}
		if (month == 3) {
			return 31;
		}
		if (month == 4) {
			return 30;
		}
		if (month == 5) {
			return 31;
		}
		if (month == 6) {
			return 30;
		}
		if (month == 7) {
			return 31;
		}
		if (month == 8) {
			return 31;
		}
		if (month == 9) {
			return 30;
		}
		if (month == 10) {
			return 31;
		}
		if (month == 11) {
			return 30;
		}
		if (month == 12) {
			return 31;
		} else {
			return 29;
		}

	}

	// Method that builds the header design
	public static void header() {
		System.out.printf("%5s", "Sun");
		System.out.printf("%6s", "Mon");
		System.out.printf("%6s", "Tue");
		System.out.printf("%6s", "Wed");
		System.out.printf("%6s", "Thur");
		System.out.printf("%6s", "Fri");
		System.out.printf("%6s", "Sat");
		System.out.println("");
		System.out.print("+");
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("-");
			}
			System.out.print("+");
		}
		System.out.println("");
		;
	}

	// Method that builds the footer design
	public static void footer() {
		System.out.print("+");
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 5; i++) {
				System.out.print("-");
			}
			System.out.print("+");
		}
	}
}
