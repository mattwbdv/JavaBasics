// Matt Koenig
// CS 210
// October 5, 2018

public class Quiz3 {
	public static void main(String[] args) {
		System.out.println(pentagonArea(3.14));
		System.out.println(addSpaces("aBcD"));
	}

	// Uses formula from Google to calculate area of a pentagon from a side length
	public static double pentagonArea(double a) {
		double answer = 0.25 * ((Math.pow(a, 2)) * (Math.sqrt(((Math.sqrt(5)) * 2 + 5) * 5)));
		return answer;
	}

	// Passes through string and adds a space between letters
	public static String addSpaces(String b) {
		String spaces = "";
		for (int i = 0; i < b.length(); i++) {
			spaces = spaces + b.charAt(i) + " ";
		}
		return spaces;
	}

}
