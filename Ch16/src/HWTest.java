
public class HWTest {
	public static void main(String[] args) {
		 LinkedList<String> A = new LinkedList<String>();
		 LinkedList<Integer> B = new LinkedList<Integer>();

		 B.deleteBack();
		 System.out.println(B.toString());  //[1, 1, 19, 19, 4, 4, 17, 17] 
		 System.out.println(B.backwards()); //[17, 17, 4, 4, 19, 19, 1, 1]
		 A.removeAll("nothing");
	}

}
