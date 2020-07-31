
// Matt Koenig
// CS 211
// Bellevue College
// Feb 4, 2019

import java.util.*;

public class Chapter14 {

	// Default constructor
	// NOTE: there are no fields in this program
	Chapter14() {

	}

	// returns a stuttered stack of calendar dates, leaves original stack unchanged
	public static Stack<CalendarDate> stutter(Stack<CalendarDate> st) {
		Stack<CalendarDate> st2 = new Stack<CalendarDate>();
		Stack<CalendarDate> st3 = new Stack<CalendarDate>();
		for (int i = st.size(); i > 0; i--) {
			CalendarDate n = st.pop();
			st2.push(n);
			st2.push(n);
			st3.push(n);
		}

		for (int j = st3.size(); j > 0; j--) {
			st.push(st3.pop());
		}
		return st2;

	}

	// uses compareTo to determine if two calendar dates equal each other; returns
	// boolean
	public static boolean equals(Stack<CalendarDate> st1, Stack<CalendarDate> st2) {

		Stack<CalendarDate> st3 = new Stack<CalendarDate>();
		boolean returnStatus = true;
		if (st1 == st2) {
			return true;
		}
		if (st1.size() != st2.size()) {
			returnStatus = false;
		} else if ((st1 == null || st2 == null)) {
			returnStatus = false;
		} else {

			while (st1.empty() == false) {
				CalendarDate first = st1.pop();
				CalendarDate second = st2.pop();
				st3.push(first);
				st3.push(second);

				if (first == second) {
					returnStatus = true;
				} else {
					returnStatus = false;
					break;
				}
			}

			while (st3.empty() == false) {
				st2.push(st3.pop());
				st1.push(st3.pop());
			}
		}
		return returnStatus;

	}

	// uses compareTo to determine if a stack of calendar dates is sorted; returns
	// boolean
	public static boolean isSorted(Stack<CalendarDate> sta) {
		boolean answer = true;
		Stack<CalendarDate> sta2 = new Stack<CalendarDate>();
		if (sta.size() == 1 || sta.size() == 0) {
			answer = true;
		} else {

			CalendarDate firstTemp = sta.pop();
			sta2.push(firstTemp); // adds the first one (fence-post)
			while (!sta.empty()) {
				CalendarDate temp = sta.pop();
				if (temp.compareTo(firstTemp) < 0) {
					answer = false;
				}
				firstTemp = temp;
				sta2.push(firstTemp);
			}

			while (!sta2.empty()) {
				sta.push(sta2.pop());

			}
		}
		return answer;

	}

	// uses compareTo to determine the minimum calendar date and return a stack of
	// calendar dates with all instances of this date removed
	public static CalendarDate removeMin(Stack<CalendarDate> sta) {
		Queue<CalendarDate> que = new LinkedList<CalendarDate>();
		CalendarDate tempMin = sta.pop();
		que.add(tempMin);

		while (sta.empty() == false) {
			CalendarDate tempMinLoop = sta.pop();
			que.add(tempMinLoop);
			if (tempMinLoop.compareTo(tempMin) <= 0) {
				tempMin = tempMinLoop;
			}

		}
		while (que.isEmpty() == false) {
			CalendarDate tempLoop2 = que.remove();
			if (tempLoop2.compareTo(tempMin) == 0) {
			} else {
				sta.push(tempLoop2);
			}

		}

		while (!sta.empty()) {
			que.add(sta.pop());
		}

		while (!que.isEmpty()) {
			sta.push(que.remove());
		}

		return tempMin;

	}

}
