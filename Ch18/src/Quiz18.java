
public class Quiz18 {
	// Might have equals done if you did the homework???
	 public static void main(String[] args) {
	   HashSet<Character> test1 = new HashSet<Character>();
	   test1.add((char)97); test1.add('b'); test1.add('c');
	   System.out.println(test1); // [a,b,c] 
	   System.out.println(test1.contentsEqual(test1)); // true
	 
	 // char 97, 107, and 117 all three hash to 7
	   test1.add((char)107); test1.add((char)117);
	   System.out.println(test1); // [u,k,a,b,c]
	   System.out.println(test1.longestLinkedList()); // 3
	 }
}
