// Matt Koenig
// CS 210, Bellevue College
// September 21, 2018
// Chapter 1 Quiz

public class ThreeLines {
	public static void main(String [] args) {
		headerFooter();
		namePortion();
		headerFooter();
	}
	public static void headerFooter() {
		stars(); // creating a header and footer
		stars();
		stars();
	}
	public static void stars() {
	System.out.println("   ******************"); // the stars that make up the header and footer
	}
	public static void namePortion() {
		nameBadge(); // printing name badge three times to make up the name portion of final art
		nameBadge();
		nameBadge();
	}
	public static void nameBadge() {
		System.out.println("  ////////////////////"); // top line of art
        System.out.println("<||   MATT KOENIG   ||>"); // name inside box
        System.out.println("  \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"); // bottom line of art, note escape key hence double length
	}
}
