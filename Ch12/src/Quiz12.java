
// Matt Koenig
// January 28, 2019
// Quiz 12
import java.io.File;

public class Quiz12 {
	// one field as the root to search from
	private File root;

	// constructor must have root parameter
	public Quiz12(String path) {
		root = new File(path);
	}

	// public method
	public int fileCount() {
		return fileCount(root);
	}

	// recursive method to count files in the directory or root folder
	private int fileCount(File next) {
		int fileCount = 0; // starts counter at 0
		if (next.listFiles() == null) { // returns 0 if there's no files in the folder
			return 0;
		}
		File[] listOfFiles = next.listFiles(); // creates an array list of files
		for (File nextFile : listOfFiles) { // looks for the next file in the array list
			if (nextFile.isFile()) { // for every file in the list, add one to counter
				fileCount++;
			}
			if (nextFile.isDirectory()) { // for every "directory" in the list, open it recursively
				fileCount += fileCount(nextFile); // recursive call to sum those files in that directory

			}
		}

		return fileCount; // return the final number
	}
}
