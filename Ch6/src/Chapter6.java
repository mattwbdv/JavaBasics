import java.io.*;
import java.util.*;

public class Chapter6 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("website.txt"));
		System.out.print(countWords(input));

	}

	public static int countWords(Scanner input) {
		int wordCounter = 0;
		while (input.hasNextLine()) {
			wordCounter++;
			input.next();

		}
		return wordCounter;
	}
}
