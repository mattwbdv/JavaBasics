import java.util.*;

public class PracticeIt {
	public static void main(String[] args) {
		List<Integer> test1 = new LinkedList<Integer>();
		test1.add(1);
		test1.add(2);
		test1.add(3);
		test1.add(4);
		test1.add(5);
		List<Integer> test2 = new LinkedList<Integer>();
		test2.add(6);
		test2.add(7);
		test2.add(8);
		test2.add(9);
		test2.add(10);
		test2.add(11);
		test2.add(12);
		System.out.println(alternate(test1, test2));
	}
	
	public static List<Integer> alternate (List<Integer> listOne, List<Integer> listTwo) {
	    List<Integer> listThree = new LinkedList<Integer>();
        Iterator<Integer> d = listOne.iterator();
        Iterator<Integer> j = listTwo.iterator();

        while(d.hasNext() && j.hasNext()) {
            listThree.add(d.next());
            listThree.add(j.next());
        }
        while(d.hasNext()) {
            listThree.add(d.next());
        }
        while(j.hasNext()) {
            listThree.add(j.next());
        }
        
	        	        return listThree;

	    }
}
