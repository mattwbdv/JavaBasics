
public class extra3 {
	public static void main(String[] args) {
	//	printReverse("hello there!");
		System.out.println(printReverse("hello there!"));
	}

	public static String printReverse(String g) {
		String reverse = "";
		for (int i = g.length() - 1; i >= 0; i--) {
			reverse = reverse + g.charAt(i);
		}
		return reverse;
	}
}
