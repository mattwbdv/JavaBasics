import java.util.Arrays;
import java.util.Scanner;

// Matt Koenig
// CS 210
// November 9, 2018
// Quiz #7

public class Quiz7 {
	
	// This program counts longest strings of characters or digits (depending on if it has a String array passed through or a int array passed though). 
	// It then counts how often this length is present in the program, and returns the value. If there are no values for either, it will return 0. 
	public static void main(String[] args) {
		String[] arguments = { "Long", "asdf", "Last", "asdf" };
		int[] list1 = { 1, 12, 222, 14, 987, 592 };
		int[] list2 = { 6, 5, 9, 7, 4, 1 };
		int score = 10;
		// Part A.
		if (countLongest(args) == 0)
			score += 5;
		if (countLongest(arguments) == 1)
			score += 5;
		// Part B.
		if (countLongest(list1) == 3)
			score += 5;
		if (countLongest(list2) == 6)
			score += 5;
		System.out.println(score); // 10 points just to compile
	}

	// METHOD 1
	public static int countLongest(String[] list) {
		int longestLength = 0;
		int longestLengthIncidence = 0;

		// loops and finds the longest length string
		for (int i = 0; i < list.length; i++) {
			String temp = list[i];
			if (temp.length() > longestLength) {
				longestLength = list[i].length();
			} else if (temp.length() == longestLength) {
				longestLengthIncidence++; // occured once
			}
		}

		// loops and finds any duplicates of this length
		for (int j = 0; j < list.length; j++) {
			if (list[j].length() == longestLength) {
				longestLengthIncidence++; // occured again
			}
		}

		// returns final answer
		return longestLengthIncidence;
	}

	// METHOD 2
	public static int countLongest(int[] list) {
		int longestLength = 0;
		int longestLengthIncidence = 0;

		// loops and converts ints to a string
		for (int i = 0; i < list.length; i++) {
			int next = list[i];
			String temp = "";
			while (next % 10 != 0) {
				temp = (next % 10) + "" + temp;
				next /= 10;
			}

			// logic to determine the longest length number
			if (temp.length() > longestLength) {
				longestLength = temp.length();
				longestLengthIncidence = 1; // occurred once 

			} else if (temp.length() == longestLength) {
				longestLengthIncidence++; // occurred again
			}

		}

		return longestLengthIncidence;
	}
}
