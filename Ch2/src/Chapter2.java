// Matt Koenig
// CS 210, Bellevue College
// September 28, 2018
// Chapter 2 Quiz

public class Chapter2 {
	// This program calls two methods and produces an inverted 10-line triangle
	// using * characters, starting with 19 stars and subtracting 2 each line to
	// result in 1 star that points to the number 13 in the fibonacci sequence that
	// ends at 144
	public static void main(String[] args) {
		triangle();
		fibonacci();
	}

	// Here is the triangle method. I started the nested for loop using "j" at -2 in
	// order to move the triangle right above the start of the "1" in 13 per the
	// project spec. I could have moved this using whole numbers, but for ease of
	// use and to keep consistent number conventiones across the program I simply
	// used a negative.
	public static void triangle() {
		int num = 19;
		for (int i = 1; i < 11; i++) {
			for (int j = -2; j < i; j++) {
				System.out.print(" ");
			}
			for (int a = 0; a < num; a++)
				System.out.print("*");
			num = num - 2;
			System.out.println();
		}
	}

	// This is the fibonacci method that uses a few variables to begin and then
	// calculates the next number using a combination of those prior variables. The
	// loop ends after 10 sequences, effectively the number 144 in the sequence.
	public static void fibonacci() {
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

	}
}
