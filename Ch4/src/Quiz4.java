// Matt Koenig
// CS 210
// October 12, 2018
// Quiz 4

public class Quiz4 {
	public static void main(String[] args) {
		System.out.println(convergentSeries(7));	
		System.out.println(convergentSeries(777));	
		System.out.println(convergentSeries(777777));
		System.out.println(reverseStutter("12345"));
		System.out.println(reverseStutter("Stop"));
	}
	public static double convergentSeries(int n) {
		double sum = 0.0;
		for (int i = 1; i <= n; i++) {
			sum += (Math.pow(-1.0, i)) / (Math.pow(i, 2));
		}
		return sum;
	}
	
	public static String reverseStutter(String g) {
		String boom = "";
		int characters = g.length();
		for (int i = characters; i > 0; i--) {
			boom += g.charAt(i - 1);
			boom += g.charAt(i - 1);
		}
		return boom.toUpperCase();
	}

}
