// Matt Koenig
// CS 210
// November 6, 2018
// Coding Assignment #7


import java.io.*;
import java.util.*;

public class SumBigInts {
	public static final int MAX_DIGITS = 25;

	// This program calculates the sum of any number of integers with any length
	// from a file with maximum size specified in MAX_DIGITS
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("sum.txt"));
		processFile(input);

	}

	// This method processes the file and calls other methods to assist in
	// calculation
	public static void processFile(Scanner input) {
		// Class constants
		int lineCounter = 0;
		int numCounter = 0;

		// This evaluates the file while it has another new line
		while (input.hasNextLine()) {
			String sumLine = input.nextLine();
			Scanner readNextNum = new Scanner(sumLine);

			// This loops through the current line and performs necessary methods
			int[] sum = new int[MAX_DIGITS];
			while (readNextNum.hasNext()) {
				// This solves a fence-post problem with the first "+"
				if (numCounter == 0) {
					lineToArrays(input, readNextNum, sum);
					numCounter++;
				} else {
					System.out.print(" + ");
					lineToArrays(input, readNextNum, sum);
				}
			}
			numCounter = 0;
			formatFinalAnswer(sum);
			System.out.println();
			lineCounter++;
		}
		System.out.println();

		// This prints the "Total lines" portion of the output
		System.out.println("Total lines = " + lineCounter);
	}

	// This method takes the the full line as well as the next integer from the line
	// and turns each integer into a respective array that is aligned to the right
	// of the array
	public static int[] lineToArrays(Scanner input, Scanner readNextNum, int[] sum) {
		// Class constants
		int counter = 1;
		int[] temp = new int[MAX_DIGITS];
		String nextInt = readNextNum.next();

		// Loop to traverse array and put string digits at end of array
		for (int i = nextInt.length() - 1; i >= 0; i--) {
			temp[MAX_DIGITS - counter] = (nextInt.charAt(i) - 48);
			counter++;
		}
		for (int j = MAX_DIGITS - 1; j > -1; j--) {
			sum[j] = temp[j] + sum[j];
		}

		// This is where actual output occurs
		// Builds edge-case tester
		String edgeCase = "";
		for (int z = 0; z < MAX_DIGITS; z++) {
			edgeCase += 0;
		}
		String nextNumber = "";
		for (int m = 0; m < MAX_DIGITS; m++) {
			nextNumber = nextNumber + "" + (temp[m]);
		}
		int tempLength = nextNumber.length();
		for (int g = 0; g < nextNumber.length(); g++) {
			if (nextNumber.charAt(g) != '0') {
				nextNumber = nextNumber.substring(g, tempLength);
				break;
			} else if (nextNumber.equals(edgeCase)) {
				nextNumber = "0";
			}
		}

		System.out.print(nextNumber);

		// Returns temp array before moving to next number
		return temp;

	}

	// This method takes two scanners and two arrays and creates a sum array
	public static int[] currentSumArray(Scanner input, Scanner readNextNum, int[] temp, int[] sum) {
		for (int j = MAX_DIGITS - 1; j > -1; j--) {
			sum[j] += temp[j];
		}

		return sum;

	}

	// This method caluclates the above sum array into an actual final number with
	// proper addition such that there is only one digit in each array index
	public static int[] formatFinalAnswer(int[] sum) {
		int[] answer = new int[MAX_DIGITS];
		for (int j = MAX_DIGITS - 1; j > -1; j--) {
			answer[j] += sum[j];
			if (answer[j] > 9) {
				int tempAns = answer[j];
				answer[j] %= 10;
				answer[(j - 1)] = tempAns / 10;
			}
		}
		// This is where the actual output occurs
		String nextNumber = "";
		String edgeCase = "";

		// Builds edge-case tester to be used later in program
		for (int z = 0; z < MAX_DIGITS; z++) {
			edgeCase += 0;
		}

		// This solves the actual math of the problem
		for (int m = 0; m < MAX_DIGITS; m++) {
			nextNumber = nextNumber + "" + (answer[m]);
		}

		// This solves the edge case if a number has leading zeros in the string
		int tempLength = nextNumber.length();
		for (int g = 0; g < nextNumber.length(); g++) {
			if (nextNumber.charAt(g) != '0') {
				nextNumber = nextNumber.substring(g, tempLength);
				break;
			} else if (nextNumber.equals(edgeCase)) {
				nextNumber = "0";
			}
		}
		System.out.print(" = " + nextNumber);

		return answer;
	}

}
