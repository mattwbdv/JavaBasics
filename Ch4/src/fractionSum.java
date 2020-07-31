public class fractionSum {

	public static void main(String[] args) {
		System.out.println(doWork(3));
hustle(5, 5);
	}

	public static double doWork(int n) {
		double sum = 1.0;
		for (int i = 1; i <= n; i++) {
			sum += (1.0 / i);
		}
		return sum;
	}

	public static void hustle(int i, int g) {
		if (i < g) {
			for (int y = i; y <= g; y++) {
				System.out.print (y + " ");
			}
		} else if (i > g) {
			for (int y = i; y >= g; y--) {
				System.out.print (y + " ");
			}
		} else {
			System.out.print (i + " ");
		}

	}

}
