
public class homeworkAssignments {
	public static void main(String[] args) {
		showTwos(68);

	}
	public static void showTwos(int f) {
		System.out.print(f + " = ");
		int temp = f;
		while (temp % 2 == 0) {
			System.out.print(2 + " * ");
			temp = temp / 2;
		}
		System.out.print(temp);
	}
}
