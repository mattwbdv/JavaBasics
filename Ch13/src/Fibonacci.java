import java.math.BigInteger;
import java.util.*;

// Matt Koenig
// January 23, 2019
// Assignment 12 

//TEACHER NOTES
/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2019
 */

public class Fibonacci {

	// fields, ONE is in any version of Java already
	// but BigInteger.TWO requires Java 9 or higher, so I make one here
	private final BigInteger TWO = new BigInteger("2");
	private final BigInteger ONE = new BigInteger("1");
	private int n; // the boring old 32-bit limited int

	// only one constructor needed
	public Fibonacci(int number) {
		n = number;
	}

	// Chapter 12, Exercise 2, code from page 128-9.
	public int fibForLoop() {
		int n1 = 1;
		int n2 = 1;
		for (int i = 3; i <= n; i++) {
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n2;
	}

	// Chapter 12, same exercise
	// public accessor into recursive helper
	public int fibonacci() {
		return fibonacci(n);
	}

	// private recursive helper given in text
	// Chapter 12, page 821
	private int fibonacci(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// Exactly the same concept as above, but using BigInteger
	// This allows us to go up to any size integer
	public BigInteger bigFib() {
		return bigFib(new BigInteger(Integer.toString(n)));
	}

	// recursive helper
	private BigInteger bigFib(BigInteger n) {
		if (n.compareTo(TWO) <= 0) {
			return ONE;
		} else {
			return bigFib(n.subtract(ONE)).add(bigFib(n.subtract(TWO)));
		}
	}

	// public accessor into recursive helper
	public BigInteger bigFastFib() {
		return bigFastFib(new BigInteger(Integer.toString(n)));
	}

	// private accessor converts BigInteger to int and jumps into recursive helper
	private BigInteger bigFastFib(BigInteger n) {
		int j = n.intValue();
		return bigFastFibRecursive(ONE, TWO, j);
	}

	// private recursive method, uses a counter so it only calls itself 2^n times
	private BigInteger bigFastFibRecursive(BigInteger firstInteger, BigInteger secondInteger, int counter) {
		if (counter == 3) {
			return secondInteger;
		} else {
			firstInteger = secondInteger.add(firstInteger);
			return bigFastFibRecursive(secondInteger, firstInteger, counter - 1);
		}
	}
}
