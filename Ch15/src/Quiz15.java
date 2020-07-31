
public class Quiz15 {
	public static void main(String[] args) {
		   ArrayList<Integer> quiz15 = new ArrayList<Integer>();
		   quiz15.mirror();
		   System.out.println(quiz15); // []
		   quiz15.add(1); quiz15.add(2); quiz15.add(3);
		   quiz15.mirror();
		   System.out.println(quiz15); // [1, 2, 3, 3, 2, 1]
		   quiz15.mirror();
		   System.out.println(quiz15); // [1, 2, 3, 3, 2, 1, 1, 2, 3, 3, 2, 1]
		}
}
