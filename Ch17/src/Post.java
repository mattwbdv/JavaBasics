// Basic tests for Chapter 17 Exercises
// upgraded into generic Search Tree use
// CS211, March 2017, W.P. Iverson, instructor
public class Post {

	public static void main(String[] args) {

		SearchTree<Double> empty = new SearchTree<Double>();
		SearchTree<CalendarDate> test = new SearchTree<CalendarDate>();
		test.add(new CalendarDate(1,1,2017));  test.add(new CalendarDate(12,12,2016));
		
//		A.  Exercise #7   isFull();		
		System.out.println(test.isFull());	// false
		System.out.println(empty.isFull());	// true
		
//		B.  Exercise #9   equals(t2);		
		System.out.println(test.equals(test));	// true
		System.out.println(test.equals(empty)); // false
		
//		D.  Exercise #12    removeLeaves();
		empty.removeLeaves();	empty.print();	// nothing to print
		test.removeLeaves();	test.print();// [1/1/2017]
		
//		C.  remove process explained in detail via PowerPoint at BJP site		
		empty.remove(42.);  empty.print();	// nothing to print
		test.remove(new CalendarDate(1,1,2017));  test.print(); // all gone
	}
}
