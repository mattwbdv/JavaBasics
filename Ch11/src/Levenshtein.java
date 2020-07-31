import java.util.*;

// Matt Koenig
// CS 211
// Jan 16, 2019

public class Levenshtein {
	private Map<String, List<String>> dictionaryMap = new HashMap<String, List<String>>();
	private ArrayList<String> path = new ArrayList<String>();

	// default constructor
	public Levenshtein() {
		dictionaryMap = new HashMap<String, List<String>>();
		path = new ArrayList<String>();
		
	}
	
	// constructor, also creates the dictionaryMap
	public Levenshtein(ArrayList<String> words) {
		String key = "";
		for (String temp : words) {
			key = temp;
			ArrayList<String> tempList = wordLoop(key, words);
			dictionaryMap.put(key, tempList);

		}

	}

	// wordLoop to build the values in map of words associated with the key
	public ArrayList<String> wordLoop(String key, ArrayList<String> words) {
		ArrayList<String> tempList = new ArrayList<String>();
		for (String temp : words) {
			if (temp == key) {

			} else {
				if (isOneAway(key, temp)) {
					tempList.add(temp);

				}
			}
		}
		return tempList;
	}

	// logic to determine if the strings are one move apart or not
	public boolean isOneAway(String s, String g) {
		int counter = 0;
		int loopLength = Math.min(g.length(), s.length());
		int difference = Math.abs(g.length() - s.length());
		boolean finalReturn = true;

		// if strings are identical
		if (g.equalsIgnoreCase(s)) {
			finalReturn = false;

		} else {

			// strings not identical, looping to find differences
			for (int i = loopLength - 1; i >= 0; i--) {
				if (g.charAt(i) == s.charAt(i)) {

				} else {
					counter++;

				}
			}

			if (difference + counter <= 1) {
				finalReturn = true;

			} else {
				finalReturn = false;
			}

		}
		return finalReturn;
	}

	// getMap method described in the spec
	public Map<String, List<String>> getMap() {
		return dictionaryMap;
	}

	// gets distance (one less than path) or -1 if path is empty
	public int getDistance(String wordOne, String wordTwo) {
		if (path.size() == 0) {
			return -1;
		} else {
			return path.size() - 1;
		}
	}

	public List<String> getPath(String wordOne, String wordTwo) {
		int numbersApart = numDiff(wordOne, wordTwo);
		int movingNumApart = numDiff(wordOne, wordTwo);
		String tempEval = wordOne;
		List<String> wordMap = dictionaryMap.get(tempEval);

		// adds first word
		path.add(wordOne);


		// loops enough times to get intermediate words
		for (int i = 0; i < numbersApart - 1; i++) {
			String nextWord = nextWord(tempEval, wordMap, wordTwo, movingNumApart);
			path.add(nextWord);
			tempEval = nextWord;
			wordMap = dictionaryMap.get(nextWord);
			movingNumApart--;
		}

		// adds last word and returns path
		path.add(wordTwo);
		return path;

	}
// determines the next word in the path 
	public String nextWord(String tempEval, List<String> wordMap, String wordTwo, int numbersApart) {
		String nextWord = "";
		for (int j = 0; j < wordMap.size(); j++) {
			if (numDiff(wordMap.get(j), wordTwo) == (numbersApart - 1)) {
				nextWord = wordMap.get(j);
				break;
			}
		}
		return nextWord;
	}

	// determines the number of different characters between two equal strings 
	public int numDiff(String a, String b) {
		int numDiff = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				numDiff++;
			}
		}
		return numDiff;
	}

}
