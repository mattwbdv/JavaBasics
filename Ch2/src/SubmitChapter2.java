// Matt Koenig
// CS 210, Bellevue College
// September 26, 2018
// Chapter 2 Homework

public class SubmitChapter2 {
	public static void main(String[] args) {
		// fibonacci
		int first = 1;
		int second = 1;
		int third = 2;
		int newNum;
		System.out.print(first + " " + second + " " + third + " ");
		for (int i = 0; i < 9; i++) {
			newNum = first + second;
			first = second;
			second = newNum;
			System.out.print(first + second + " ");
		}

		// I put these in to space out the output in console such that the output can be
		// easily compared against the solution
		System.out.println();
		System.out.println();

		// numberTriangle
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}

		// I put these in to space out the output in console such that the output can be
		// easily compared against the solution
		System.out.println();

		// spacesAndNumbers
		int num = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int a = 0; a < num; a++)
				System.out.print(num);
			num++;
			System.out.println();
		}
	}
}
