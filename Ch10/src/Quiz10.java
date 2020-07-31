
import java.util.ArrayList;

// Matt Koenig
// CS 211
// Quiz 10
// January 14, 2019


// starter code:
public class Quiz10 {
	public static void main(String[] a) {
		ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>();
		dates.add(new CalendarDate(5, 5, 2018));
		dates.add(new CalendarDate(10, 2, 2018));
		dates.add(new CalendarDate(10, 7, 2017));
		dates.add(new CalendarDate(10, 7, 2017));

		System.out.println("Before: " + dates);
		minToFront(dates);
		System.out.println("After moving minimum to front: " + dates);
	}

// my code
	// finds the minimum date in the array list
	public static void minToFront(ArrayList<CalendarDate> list) {
		CalendarDate minDate = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).compareTo(minDate) < 0) {
				minDate = list.get(i);
			}
		}

		// finds out how many times that date occurs and stores all the occurrence in an
		// index
		ArrayList<Integer> index = new ArrayList<Integer>();
		for (int c = 0; c < list.size(); c++) {
			if (list.get(c).compareTo(minDate) == 0) {
				index.add(c);
			}
		}

		// removes all occurrences from original index
		int tempCounter = 0;
		for (int j = 0; j < index.size(); j++) {
			int removeIndex = index.get(j - tempCounter);
			list.remove(removeIndex);
			tempCounter++;
		}

		// adds all occurrences to the front of the original index
		for (int w = 0; w < index.size(); w++) {
			list.add(0, minDate);
		}
	}
}
