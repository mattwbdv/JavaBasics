
public class PracticeIt {

	public static void main(String[] args) {
		// BJP 12.1
		System.out.println(starString(4));
		System.out.println(multiplyEvens(3));
		System.out.println(sumTo(2));
		System.out.println(evenDigits(-7010496));



	}

	// BJP 12.1
	public static int starNum(int y) {
		int x = 2;

		if (y < 0) {
			throw new IllegalArgumentException();
		} else if (y == 0) {
			return 1;
		}

		else {
			return x * starNum(y - 1);
		}

	}

	public static String starString(int y) {
		String stars = "";
		for (int i = 0; i < starNum(y); i++) {
			stars += "*";
		}
		return stars;
	}

	// BJP 12.8
	public static int multiplyEvens(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		} else if (n == 1) {
			return 2;
		} else { 
			return n * 2 * multiplyEvens(n -1);
		}
	}
	
	
	// BJP 12.9
	public static double sumTo(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return 0.0;
		} else if (n == 1) {
			return 1;
		} else {
			return (1.0/n) + sumTo(n-1);
		}
	}

	
	// BJP 12.14
	public static int evenDigits(int n) {
		int temp = (n) % 10;
		if (n == 0) {
			return 0;
		} else if (temp % 2 == 0) {
			return 10 * evenDigits(n / 10) + temp;
		} else {
			return evenDigits(n / 10);
		}
		
	}
	
	
	// BJP 12.13
	
}
