
public class spacedNumbers {

	public static void main(String[] args) {
		int num = 1;
		for (int i = 1; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			System.out.println(num);
			num++;

		}
		System.out.println(num);
	}
}
