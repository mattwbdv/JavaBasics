
	// Code to post with Quiz16
	public class QuizTest {
	 public static void main(String[] args) {
	 LinkedList<Integer> aList = new LinkedList<Integer>();
	 System.out.println(aList.isPerfectStutter()); // false
	 aList.add(1); aList.add(1); 
	 aList.add(2); aList.add(2);
	 System.out.println(aList); // [1, 1, 2, 2]
	 System.out.println(aList.isPerfectStutter()); // true
	 aList.undoStutter(); 
	 System.out.println(aList); // [1, 2]
	 }
	}

