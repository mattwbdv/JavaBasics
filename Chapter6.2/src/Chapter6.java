
// Matt Koenig
// BC | CS 210
// November 2, 2018
// Quiz 6

import java.io.*;
import java.util.*;

public class Chapter6 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("whatever.txt"); // any file will work
		Scanner input = new Scanner(file);
		System.out.println(oneLiner(input));
	}

	// This method takes a scanner input and reads each line. It then creates a new
	// scanner to read each word from that line. Finally, it builds a string with
	// these words and a space after each one and returns it to main.
	public static String oneLiner(Scanner input) {
		String answer = "";
		while (input.hasNextLine()) {
			String currentLine = input.nextLine();
			Scanner wordScanner = new Scanner(currentLine);
			while (wordScanner.hasNext()) {
				answer += (wordScanner.next() + " ");
			}
		}
		return answer;
	}
}
