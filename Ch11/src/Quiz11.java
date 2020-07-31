
// Matt Koenig
// CS 211
// January 21, 2019

import java.util.*;

// starter code:
public class Quiz11 {
	public static void main(String[] args) {
		ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>();
		list1.add(new CalendarDate(1, 2, 1903));
		list1.add(new CalendarDate(2, 3, 1904));
		System.out.println(maxOccurrences(list1)); // 3
		System.out.println(maxUsingIterator(list1)); // 5/5/2018
	}

	// uses hashmap to determine the most frequent date and return its number of
	// occurrences
	public static int maxOccurrences(List<CalendarDate> quiz) {
		Integer maxOccurrences = 0;
		Map<CalendarDate, Integer> modeMap = new HashMap<CalendarDate, Integer>();
		Collection<Integer> maxKeySet = new HashSet<Integer>();
		for (int i = 0; i < quiz.size(); i++) {
			if (modeMap.containsKey(quiz.get(i))) {
				int tempValue = modeMap.get(quiz.get(i));
				tempValue++;
				modeMap.remove(quiz.get(i));
				modeMap.put(quiz.get(i), tempValue);
			} else {
				modeMap.put(quiz.get(i), 1);
			}
		}
		maxKeySet = modeMap.values();
		Iterator<Integer> itr = maxKeySet.iterator();
		while (itr.hasNext()) {
			if (itr.next() > maxOccurrences) {
				maxOccurrences = itr.next();
			}
		}
		return maxOccurrences;
	}

	// uses compareTo and iterator to determine the largest calendar date
	public static CalendarDate maxUsingIterator(List<CalendarDate> quiz) {

		Iterator<CalendarDate> itr = quiz.iterator();
		CalendarDate maxDate = new CalendarDate(1, 1, 1970);

		while (itr.hasNext()) {
			CalendarDate temp = itr.next();
			if (temp.compareTo(maxDate) > 0) {
				maxDate = temp;
			}

		}
		return maxDate;
	}
}