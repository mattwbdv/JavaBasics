import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class test {
	
	public static void main(String[] args) throws FileNotFoundException{
		 // section of code to read data file
		Scanner file = new Scanner(new File("dictionary.txt"));
		ArrayList<String> words = new ArrayList<String>();
		while (file.hasNext()) words.add(file.next());
		file.close();

		// section of code to test your data structure
		Levenshtein structure = new Levenshtein(words); // builds Map from List of words
		System.out.println(structure.getMap());         // displays the Map from above
		System.out.println(structure.getMap().size());            // size of above Map
		System.out.println(structure.getPath("dog","cat"));       // displays path as described in text
		System.out.println(structure.getDistance("dog","cat"));   // the "distance" as described in text
		
}
}


