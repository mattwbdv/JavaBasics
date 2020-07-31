import java.util.*;

public class Summer2018midterm {
	
	public static final int N = 100;

	public static void main(String[] args) {
		/* CS CS211 mid-term exam, Summer 2018 			NAME:_________________________
		*  W.P. Iverson, instructor
		*  Below is a working program. You should have sufficient experience
		*  now to think like the computer, and know what output is produced.
		*  Instructions: Write expected output for each numbered line below, or write code as instructed.
		*  5 points per numbered item.
		*  In rare cases, an Object has no useful toString(); write HEX in those cases
		*/
				Integer zero = Integer.valueOf(0);	// returns Integer(0) object
				Integer five = Integer.valueOf(5);	// replaces depricated Integer(5);
				Integer negativeSix = Integer.valueOf(-6);	// see above

				// Starting with some hopefully easy things to figure out:
				System.out.println(5 < -6);							// 1.
				System.out.println(five.compareTo(negativeSix));	// 2.
			
				System.out.println(five == negativeSix);			// 3.
				System.out.println(five.equals(negativeSix));		// 4.
				System.out.println(zero.compareTo(five));			// 5.
				
				// Questions using ArrayList
				ArrayList<Integer> exam = new ArrayList<Integer>();
				System.out.println(exam);						// 6.
				System.out.println(exam.size());				// 7.
				
				exam.add(zero);  exam.add(five);  exam.add(negativeSix);
				exam.add(zero);  exam.add(five);  exam.add(negativeSix);
				System.out.println(exam.get(2));				// 8.
				System.out.println(exam.size());				// 9.
				
				exam.set(2,2);					
				System.out.println(exam.get(2));				// 10.
				System.out.println(exam.size());				// 11.
				
				exam.add(2,-6);
				System.out.println(exam.get(2));				// 12.
				
				exam.remove(Integer.valueOf(1));
				System.out.println(exam.size());				// 13.
				
				exam.remove(1);
				System.out.println(exam.size());				// 14.
				System.out.println("#15: " + exam.add(2));		// 15.
				
				// Below will start ArrayList fresh (size=3)
				exam.clear();  exam.add(2);  exam.add(1);  exam.add(3);
				ArrayList<Integer> second = new ArrayList<Integer>(); 
				for (int i=1; i<=5; i++) second.add(2);
				
				exam.removeAll(second);		
				System.out.println(exam.toString());			// 16.
				
				exam.clear();  exam.add(2);  exam.add(1);  exam.add(3);
				exam.retainAll(second);		
				System.out.println(exam.toString());			// 17.
				
				exam.clear();  exam.add(2);  exam.add(1);  exam.add(3);
				System.out.println(exam.containsAll(second));	// 18.
				System.out.println(exam.contains(2));			// 19.
				
				// Questions with TreeSet
				TreeSet<Integer> data = new TreeSet<Integer>();
				data.add(zero);  data.add(five);  data.add(negativeSix);	
				data.add(zero);  data.add(five);  data.add(negativeSix);
				System.out.println(data.toString());		// 20.
				System.out.println(data.toArray());			// 21.
				
				System.out.println(data.contains(2));		// 22.	
					
				data.remove(2);
				System.out.println(data.toString());		// 23.
				
				data.remove(five);
				System.out.println(data.toString());		// 24.
				
				data.addAll(exam);
				System.out.println(data.toString());		// 25.
				
				// Assume we have a method that fills ArrayList with N elements
				fillWithN(exam);
				// 26. Determine Big-O for the following piece of code:
				exam.add(42*exam.get(0)%2);
				// choice are O(constant), O(N), O(N^2), O(logN), O(NlogN)
				
				// 27. Determine Big-O for the following piece of code:
				for (int i=0; i<N; i++) exam.add(42, exam.get(0)%2);
			
				// Below will start again ArrayList fresh (size=3)
				exam.clear();  exam.add(2);  exam.add(1);  exam.add(3);
				Iterator<Integer> itr = exam.iterator();
				System.out.println(itr.next());			// 28. 
				System.out.println(itr.next());			// 29.
				
				// See attached Class from BJP text
				Circle two = new Circle(2);	
				Circle big = new Circle(22);
				
				// On attached Class, write code so below will create a zero radius Circle object
				Circle zip = new Circle();				// 30. no output
				
				System.out.println(zip);				// 31.
				System.out.println(zip.getArea());		// 32.
				
				System.out.println(two);							// 33.
				System.out.println(two.getArea()); // estimate		// 34.
				// One or more items above (5-34) DOES output HEX from the Object
				
				ArrayList<Circle> items = new ArrayList<Circle>();
	//			Collections.sort(items); // 35. Only works when attached Class implements ??? add on attached page in correct place
				// 36. Write method(s) required to implement the interface you name here
				
				// Below are some recursive method calls, that are VERY similar to
				// homework problems from our BJP text:
				System.out.println(mystery4C(3,12));		// 37.
				System.out.println(mystery4C(12,3));		// 38.
				
				// 39. Write a recursive method toBinaryString that accepts an integer parameter n and returns a String 
				// representation of that int in base 2.  Your solution must be recursive, and do not use Integer Class
				// else you could just return Integer.toBinaryString(n)
				System.out.println(toBinaryString(43));  // "101011"
				// 40. Above counts double (10 pts).
	}

	
			public static int mystery4C(int x, int y) {
			    if (x < y) {
			        return x;
			    } else {
			        return x + mystery4C(x - 1, y + 1); 
			    }
			}
			
	
			
			
// BELOW NOT distributed with exam:		
			
			
			
			// write a recursive to Binary String
			public static String toBinaryString(int n) {
				String binary = "";
				return toBinaryString(n, binary); 
			}
			
			// helper for above
			private static String toBinaryString(int n, String binary) {
					if (n <=1 ) 
						return binary += n; 
					else 
						return toBinaryString(n/2, binary) + (n % 2);
			}
			    
			    
			    
		private static void fillWithN(ArrayList<Integer> exam) {
			for (int i=0; i<444; i++) exam.add(i);
		}
	

		

}
