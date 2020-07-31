
public class spacesAndNumbers {


	public static void main(String[] args) {
		int num = 1;
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int a = 0; a < num; a++)
			System.out.print(num);
			num++;
			System.out.println();
		}
	}
}
