
// Matt Koenig
// BC | CS 210
// October 19, 2018
// Quiz 5

import java.util.*;

public class Quiz5 {
	public static void main(String[] args) {
		// ***THIS IS MY ASSIGNMENT COMMENTARY***
		// This program accomplishes two random tasks. The first is to pass through a
		// number that becomes number of characters in a randomized string. The second
		// is to pass through a number that becomes number of digits in a random number

		// NOTE*** I commented out the loops that continue infinitely until "quiz" and
		// "1313" were achieved because these outcomes would take too long to achieve
		// given a timed quiz

		// ***THIS IS THE PROVIDED MAIN METHOD***
		// A. Random fixed length String
		String thing = randomWord(4);
		System.out.println(thing); // "fvco" on my first test
		 do {
		 thing = randomWord(4);
		 } while (!thing.equals("quiz"));
		 System.out.println(thing); // eventually I get "quiz"

		// B. Random fixed Digit Number
		int test = randomInt(4);
		System.out.println(test); // 7281 on my first test
		 do {
		 test = randomInt(4);
		 } while (test != 1313);
		 System.out.println(test); // eventually I get 1313
	}

	public static String randomWord(int a) {
		// This method passes through int a and returns a string with letters until the
		// string is the length equal to int a
		Random rand = new Random();
		String newString = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < a; i++) {
			newString = newString + "" + (alphabet.charAt(rand.nextInt(26)));

		}
		return newString;
	}

	public static int randomInt(int a) {
		// This method passes through int a and returns an int with digits until the
		// length of the number is equal to int a
		Random rand = new Random();
		int answer = 0;
		int multiplier = 10;
		for (int i = 0; i < a - 1; i++) {
			answer = (rand.nextInt(10) * multiplier) + answer;
			multiplier *= 10;
		}
		
		// Solving a fence-post edge case
		if (answer / 100 < 10) {
			answer = answer + (rand.nextInt(10) * 100);
		}
		return answer;

	}
}
