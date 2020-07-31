
public class Chapter3 {
	// This program prints example solutions to a variety of test cases for the
	// assigned PracticeIt problems
	public static void main(String[] args) {
		printPowersOf2(3); // Problem 3.2
		printPowersOf2(10); // Problem 3.2
		System.out.println(largestAbsVal(3, -5, 1)); // Problem 3.7
		System.out.println(lastDigit(237534)); // Problem 3.9
		System.out.println(scientific(1.9, -2.0)); // Problem 3.12
		System.out.println(triangleArea(8, 5.2, 7.1)); // Problem 3.16
		System.out.println(padString("hello", 8)); // Problem 3.17
		System.out.println(padString("congratulations", 10)); // Problem 3.17
	}

	// This method accepts a maximum number as an argument and prints each power of
	// 2 from 20 (1) up to that maximum power, inclusive
	public static void printPowersOf2(int num) {
		int power = 1;
		System.out.print("1 ");
		for (int i = 0; i < num; i++) {
			System.out.print((int) Math.pow(2, power) + " ");
			power++;
		}
		System.out.println();
	}

	// This method accepts three integers as parameters and returns the largest of
	// their three absolute values
	public static int largestAbsVal(int a, int b, int c) {
		int absA = Math.abs(a);
		int absB = Math.abs(b);
		int absC = Math.abs(c);
		int max = Math.max(Math.max(absA, absB), absC);
		return max;
	}

	// This method returns the last digit of an integer
	public static int lastDigit(int number) {
		int absN = Math.abs(number);
		int showtime = absN % 10;
		return showtime;
	}

	// This method accepts two real numbers as parameters for a base and an exponent
	// and computes the base times 10 to the exponent, as seen in scientific
	// notation
	public static double scientific(double x, double y) {
		double multiplier = Math.pow(10, y);
		double answer = multiplier * x;
		return answer;
	}

	// This method accepts the three side lengths of a triangle (all real numbers)
	// as parameters and returns the area of a triangle with those side lengths
	public static double triangleArea(double r, double t, double y) {
		double half = ((r + t + y) / 2);
		double tempNumTA = (half * (half - r) * (half - t) * (half - y));
		double done = Math.sqrt(tempNumTA);
		return done;

	}

	// This method accepts two parameters: a String and an integer representing a
	// length. The method should pad the parameter string with spaces until its
	// length is the given length
	public static String padString(String b, int l) {
		int length = b.length();
		int finalLength = Math.max(length, l);
		int letters = Math.min(length, finalLength);
		int spaces = finalLength - letters;
		for (int i = 0; i < spaces; i++) {
			b = " " + b;
		}
		return b;
	}
}
