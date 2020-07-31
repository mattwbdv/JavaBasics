import java.util.*;

public class RandomNum {

	public static void main(String[] args) {
		gpa();
		System.out.println();
		randomX();
	}

	public static double gpa() {
		Random rand = new Random();
		Double gpa;
		do {
			gpa = rand.nextDouble() * 2.5 + 1.5;
		} while (Math.abs(gpa - 4.0) >= 0.001);
		{
			System.out.printf(" GPA = %4.2f", gpa);
		}
		return gpa;

	}

	public static void randomX() {
		Random rand = new Random();
		int numXs;
		do {
			numXs = (rand.nextInt(15) + 5);
			for (int i = 0; i < numXs; i++) {
				System.out.print("x");
				
			}
			System.out.println();


		} while (numXs <= 15);
		{
		}

	}
}
