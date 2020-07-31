
public class quizDriver {
	public static void main(String[] args) {
	SearchTree<Integer> zero = new SearchTree<Integer>();
	SearchTree<Integer> one = new SearchTree<Integer>();
	SearchTree<Integer> two = new SearchTree<Integer>();
	one.add(9); one.add(8); one.add(7); // all left nodes
	two.add(7); two.add(8); two.add(9); // all right nodes

	System.out.println(one.equals(two)); // false
	System.out.println(one.countSameData(two)); // 3
	System.out.println(one.countSameData(one)); // 3
	System.out.println(zero.countSameData(two)); // 0
	two.remove(8);
	System.out.println(one.countSameData(two)); // 2
	}
}
