
// Matt Koenig
// CS 210
// October 9, 2018
// Coding Assignment 4 

import java.util.Calendar;
import java.util.GregorianCalendar;

// This program takes month and year both of type int and prints a calendar that accurately accounts for leap 
// years between 1900-2100
public class DayGrid {
	public static void main(String[] args) {
		int month = 12;
		int year = 2020;
		showGrid(month, year);
		System.out.println("");

	}

	// This method accounts for leap years, passing through month, year, and number
	// of days in month to the calendar builder. It also calls header and footer
	// design methods
	public static void showGrid(int month, int year) {
		int daysInMonth = 0;
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

		// int daysInMonth = tempCal.getActualMaximum(Calendar.DAY_OF_MONTH);

		// ^ This would be the most scalable way to account for leap years, but since
		// the spec
		// required the use of the daysInMonth method, it was commented out

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
		for (int m = 0; m <= daysInMonth; m++) {
			if (position % 7 == 0) {
				System.out.printf("%3d", date);
				System.out.printf("%3s", "|");
				System.out.println("");
				System.out.print("|");
				date++;
				position++;
			} else if (date <= daysInMonth) {
				System.out.printf("%3d", date);
				System.out.printf("%3s", "|");
				date++;
				position++;
			} else {

				// blank spaces after month ends
				for (int d = position; d <= 42; d++) {
					if (position == 35) {
						System.out.printf("%3s", "");
						System.out.printf("%3s", "|");
						System.out.println("");
						System.out.print("|");
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
