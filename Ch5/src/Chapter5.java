// Matt Koenig
// BC | CS 210
// October 13, 2018
// Assignment 5

public class Chapter5 {
	public static void main(String[] args) {
	      int score=0;
	      if (Chapter5.gcd(927686892, 2) == 2) score+=3; // else print comment
	      if (Chapter5.gcd(0, 0) == 0) score+=3; // else print comment
	      if (Chapter5.toBinary(88).equals("1011000")) score+=3; // else print comment
	      if (Chapter5.toBinary(0).equals("0")) score+=3; // else print comment
	      if (Chapter5.consecutive(984753,984754,984755)) score+=3; // else print comment
	      if (!Chapter5.consecutive(0, 0, 0)) score+=3; // else print comment
	      if (Chapter5.digitSum(568679) == 41) score+=3; // else print comment
	      if (Chapter5.digitSum(0) == 0) score+=3; // else print comment
	      if (Chapter5.digitRange(799857) == 5) score+=3; // else print comment
	      if (Chapter5.digitRange(0) == 1) score+=3; // else print comment
	      System.out.println(score);
	   }

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return Math.abs(a);
	}

	public static String toBinary(int c) {
		String answer = "";
		String reverseAnswer = "";
		if (c == 0) {
			return 0 + "";
		} else {
			while (c > 0) {
				int temp = c % 2;
				answer = answer + "" + temp;
				c = c / 2;
			}
			for (int i = answer.length() - 1; i >= 0; i--) {
				reverseAnswer = reverseAnswer + "" + answer.charAt(i);
			}
			return reverseAnswer;
		}
	}

	public static boolean consecutive(int a, int b, int c) {
		if (c == b + 1 && b == a + 1) {
			return true;
		} else if (a == b + 1 && c == a + 1) {
			return true;
		} else if (b == c + 1 && c == a + 1) {
			return true;
		} else {
			return false;
		}
	}

	public static int digitSum(int a) {
		int sum = 0;
		while (a != 0) {
			int temp = a % 10;
			sum += temp;
			a /= 10;
		}
		return Math.abs(sum);

	}
	
	public static int digitRange(int a) {
		int localMin = a % 10;
		int localMax = a % 10;
		int range = 0;
        if (a / 10 == 0) { 
            return 1; 
        } else {
		while (a != 0) {
			int temp = a % 10;
			if (temp < localMin) {
				localMin = temp;
				a /= 10;
			} else if (temp > localMax) {
				localMax = temp;
				a /= 10;
			} else {
				a /= 10;
			}
		}
		
		range = localMax - localMin +1;
		return range;
        
    }
	}
}