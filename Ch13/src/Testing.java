import java.math.BigInteger;
import java.time.*;

// Matt Koenig
// January 27, 2019
// Assignment Chapter 13
// CS 211 

// This is a test program to determine the run-time complexity for two methods from chapter 12
public class Testing {
	public static void main(String[] args) {


		// TEST 1 of BIG FIB -- this test evaluates data sets starting at 3 and using
		// multiples of 3 up until 30, printing out the time it takes (in milliseconds)
		// to complete each evaluation
		
		// Constructs all data-sets
		Fibonacci test3 = new Fibonacci(3); // only needed for overload
		Fibonacci test6 = new Fibonacci(6); // only needed for overload
		Fibonacci test9 = new Fibonacci(9); // only needed for overload
		Fibonacci test12 = new Fibonacci(12); // only needed for overload
		Fibonacci test15 = new Fibonacci(15); // only needed for overload
		Fibonacci test18 = new Fibonacci(18); // only needed for overload
		Fibonacci test21 = new Fibonacci(21); // only needed for overload
		Fibonacci test24 = new Fibonacci(24); // only needed for overload
		Fibonacci test27 = new Fibonacci(27); // only needed for overload
		Fibonacci test30 = new Fibonacci(30); // only needed for overload

		// Orients console
		System.out.println();
		System.out.println("TEST 1");
		System.out.println();
		
		// Runs test
		long start3 = System.currentTimeMillis();
		System.out.println(test3.bigFib()); // same as above, but use BigIntegers
		long end3 = System.currentTimeMillis();
		System.out.println("Time (3) = " + (end3 - start3));

		long start6 = System.currentTimeMillis();
		System.out.println(test6.bigFib()); // same as above, but use BigIntegers
		long end6 = System.currentTimeMillis();
		System.out.println("Time (6) = " + (end6 - start6));

		long start9 = System.currentTimeMillis();
		System.out.println(test9.bigFib()); // same as above, but use BigIntegers
		long end9 = System.currentTimeMillis();
		System.out.println("Time (9) = " + (end9 - start9));

		long start12 = System.currentTimeMillis();
		System.out.println(test12.bigFib()); // same as above, but use BigIntegers
		long end12 = System.currentTimeMillis();
		System.out.println("Time (12) = " + (end12 - start12));

		long start15 = System.currentTimeMillis();
		System.out.println(test15.bigFib()); // same as above, but use BigIntegers
		long end15 = System.currentTimeMillis();
		System.out.println("Time (15) = " + (end15 - start15));

		long start18 = System.currentTimeMillis();
		System.out.println(test18.bigFib()); // same as above, but use BigIntegers
		long end18 = System.currentTimeMillis();
		System.out.println("Time (18) = " + (end18 - start18));

		long start21 = System.currentTimeMillis();
		System.out.println(test21.bigFib()); // same as above, but use BigIntegers
		long end21 = System.currentTimeMillis();
		System.out.println("Time (21) = " + (end21 - start21));

		long start24 = System.currentTimeMillis();
		System.out.println(test24.bigFib()); // same as above, but use BigIntegers
		long end24 = System.currentTimeMillis();
		System.out.println("Time (24) = " + (end24 - start24));

		long start27 = System.currentTimeMillis();
		System.out.println(test27.bigFib()); // same as above, but use BigIntegers
		long end27 = System.currentTimeMillis();
		System.out.println("Time (27) = " + (end27 - start27));

		long start30 = System.currentTimeMillis();
		System.out.println(test30.bigFib()); // same as above, but use BigIntegers
		long end30 = System.currentTimeMillis();
		System.out.println("Time (30) = " + (end30 - start30));

		// TEST 2 of BIG FAST FIB -- this test evaluates data sets starting at 500 and using
		// multiples of 500 up until 5000, printing out the time it takes (in milliseconds)
		// to complete each evaluation
		
		// Constructs all data-sets
		Fibonacci test500 = new Fibonacci(500); // only needed for overload
		Fibonacci test1000 = new Fibonacci(1000); // only needed for overload
		Fibonacci test1500 = new Fibonacci(1500); // only needed for overload
		Fibonacci test2000 = new Fibonacci(2000); // only needed for overload
		Fibonacci test2500 = new Fibonacci(2500); // only needed for overload
		Fibonacci test3000 = new Fibonacci(3000); // only needed for overload
		Fibonacci test3500 = new Fibonacci(3500); // only needed for overload
		Fibonacci test4000 = new Fibonacci(4000); // only needed for overload
		Fibonacci test4500 = new Fibonacci(4500); // only needed for overload
		Fibonacci test5000 = new Fibonacci(5000); // only needed for overload
		
		// Orients console
		System.out.println();
		System.out.println("TEST 2");
		System.out.println();
		
		
		// Runs test
		long start500 = System.currentTimeMillis();
		System.out.println(test500.bigFastFib()); // same as above, but MUCH faster
		long end500 = System.currentTimeMillis();
		System.out.println("Time (500) = " + (end500 - start500));
		
		long start1000 = System.currentTimeMillis();
		System.out.println(test1000.bigFastFib()); // same as above, but MUCH faster
		long end1000 = System.currentTimeMillis();
		System.out.println("Time (1000) = " + (end1000 - start1000));
		
		long start1500 = System.currentTimeMillis();
		System.out.println(test1500.bigFastFib()); // same as above, but MUCH faster
		long end1500 = System.currentTimeMillis();
		System.out.println("Time (1500) = " + (end1500 - start1500));
		
		long start2000 = System.currentTimeMillis();
		System.out.println(test2000.bigFastFib()); // same as above, but MUCH faster
		long end2000 = System.currentTimeMillis();
		System.out.println("Time (2000) = " + (end2000 - start2000));
		
		long start2500 = System.currentTimeMillis();
		System.out.println(test2500.bigFastFib()); // same as above, but MUCH faster
		long end2500 = System.currentTimeMillis();
		System.out.println("Time (2500) = " + (end2500 - start2500));
		
		long start3000 = System.currentTimeMillis();
		System.out.println(test3000.bigFastFib()); // same as above, but MUCH faster
		long end3000 = System.currentTimeMillis();
		System.out.println("Time (3000) = " + (end3000 - start3000));
		
		long start3500 = System.currentTimeMillis();
		System.out.println(test3500.bigFastFib()); // same as above, but MUCH faster
		long end3500 = System.currentTimeMillis();
		System.out.println("Time (3500) = " + (end3500 - start3500));
		
		long start4000 = System.currentTimeMillis();
		System.out.println(test4000.bigFastFib()); // same as above, but MUCH faster
		long end4000 = System.currentTimeMillis();
		System.out.println("Time (4000) = " + (end4000 - start4000));
		
		long start4500 = System.currentTimeMillis();
		System.out.println(test4500.bigFastFib()); // same as above, but MUCH faster
		long end4500 = System.currentTimeMillis();
		System.out.println("Time (4500) = " + (end4500 - start4500));
		
		long start5000 = System.currentTimeMillis();
		System.out.println(test5000.bigFastFib()); // same as above, but MUCH faster
		long end5000 = System.currentTimeMillis();
		System.out.println("Time (5000) = " + (end5000 - start5000));

	}

}
