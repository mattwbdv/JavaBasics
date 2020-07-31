import java.util.*;
import java.util.stream.Collectors;

// HOMEWORK COMPLETED BY MATT KOENIG 
// March 11, 2019
// CS 211


// QUIZ COMPLETED BY MATT KOENIG 
// MARCH 18, 2019
// CS 211

public class Chapter19 {
	
	// DONE 
	// QUIZ METHOD -- STUTTERS A STRING
	public static String stutter(String phrase)  {  // -> lambda expression required
		return Arrays.stream(phrase.split(" ")).map(s -> s.substring(0) + " " + s.substring(0) + " ")
				.reduce("", (s1, s2) -> s1 + s2);
	}
	
	
	// DONE
	// 2. return the sum of the absolute values of the ints in the array
	public static int sumAbsVals(int[] a) {
		return Arrays.stream(a).map(Math::abs).sum();

	}

	// DONE
	// 4. return the sum of total area of all circles with given radii
	public static double totalCircleArea(double[] radii) {
		return Arrays.stream(radii).map(n -> n * n * 3.14159265).sum();
	}

	// DONE
	// 6. return the given phrase's words in pig latin
	public static String toPigLatin(String phrase) {
		
		return Arrays.stream(phrase.split(" ")).map(s -> s.substring(1) + "-" + s.charAt(0) + "ay ")
				.reduce("", (s1, s2) -> s1 + s2);


	}
	

	// DONE
	// 8. return string as sorted canonical form
	public static String toSortedForm(String s) {
		String answer = s.chars().sorted().map(i -> ((char) i))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return answer;

	}

	// DONE
	// 10. return string of words in the list in reverse order
	public static String glueReverse(List<String> elements) {
		return elements.stream().map(x -> new StringBuilder(x).reverse())

				.collect(Collectors.joining(" "));

	}
}
