import java.io.*;
import java.util.*;

public class SumPractice {
	public static final int MAX_DIGITS = 25;

	public static void main(String[] args) throws FileNotFoundException {
		int[] finalAnswer = new int[MAX_DIGITS];
		int[] number1 = new int[MAX_DIGITS];
		int[] number2 = new int[MAX_DIGITS];
		Scanner input = new Scanner(new File("practice.txt"));
		processFile(input, finalAnswer, number1, number2);
		System.out.println(Arrays.toString(number1));
		System.out.println(Arrays.toString(number2));
		System.out.println(Arrays.toString(finalAnswer));

	}

	public static void processFile(Scanner input, int[] finalAnswer, int[] number1, int[] number2) {
		while (input.hasNextLine()) {

			// Converts the next string to an int and then fills each digit in the array in
			// reverse order
			processNum1(input, number1);
			processNum2(input, number2);
			processAnswer(input, finalAnswer, number1, number2);
		}

	}

	public static void processNum1(Scanner input, int[] number1) {
		String nextNumber = input.next();
		int numberLength = nextNumber.length();
		int counter = 1;

		// for loop to write the numbers starting from far right in array
		for (int i = numberLength - 1; i > -1; i--) {
			number1[MAX_DIGITS - counter] = nextNumber.charAt(i) - 48;
			counter++;
		}

		// for loop to print the console text in proper order
		for (int j = 0; j < numberLength; j++) {
			System.out.print(nextNumber.charAt(j) - 48);
		}
	}

	public static void processNum2(Scanner input, int[] number2) {
		String nextNumber = input.next();
		int numberLength = nextNumber.length();
		int counter = 1;
		System.out.print(" + ");
		for (int i = numberLength - 1; i > -1; i--) {
			number2[MAX_DIGITS - counter] = nextNumber.charAt(i) - 48;
			counter++;
		}
		for (int j = 0; j < numberLength; j++) {
			System.out.print(nextNumber.charAt(j) - 48);
		}

	}

	public static void processAnswer(Scanner input, int[] finalAnswer, int[] number1, int[] number2) {
		System.out.print(" = ");
		String boom = "";
		int tens = 0;
		for (int i = MAX_DIGITS - 1; i > -1; i--) {
			finalAnswer[i] = number1[i] + number2[i] + tens;
			if (finalAnswer[i] > 10) {
				tens = finalAnswer[i] / 10 * 10;
				finalAnswer[i] = finalAnswer[i] % 10;
			} else {
				
			}
		}

		for (int j = 0; j < MAX_DIGITS; j++) {
			if (finalAnswer[j] != 0) {
				boom += finalAnswer[j];
			} else {

			}
		}
		System.out.println(boom);
	}
}
