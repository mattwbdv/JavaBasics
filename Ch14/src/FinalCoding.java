import java.util.*;

public class FinalCoding {
	public static void main(String[] args) {
		System.out.println(answer(5, 8));
		
	}
	
	public static int answer(int x, int y) {
		if (x < y) {
			return x;
			
		} else {
			return x + answer(x-2, y);
		}
	}
}
