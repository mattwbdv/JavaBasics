
public class fibonacci {
	public static void main(String[] args) {
		int first = 1;
		int second = 1;
		int third = 2;
		int newNum;
		System.out.print(first + " " + second + " " + third + " ");
		for (int i = 0; i < 9; i++) {
			newNum = first + second; 
			first = second; 
			second = newNum; 
			System.out.print(first + second + " ");
		}

	}
}
