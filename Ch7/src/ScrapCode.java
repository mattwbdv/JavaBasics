//import java.io.*;
//import java.util.*;
//
//public class SumBigInts {
//	public static final int MAX_DIGITS = 25;
//
//	public static void main(String[] args) throws FileNotFoundException {
////		int[] answerA = new int[MAX_DIGITS];
////		int[] answerB = new int[MAX_DIGITS];
//		
//		Scanner input = new Scanner(new File("sum.txt"));
//		processFile(input);
//		
//	}
//
//	public static void processFile(Scanner input) {
//		int intCounter = 0;
//		while (input.hasNextLine()) {
//			String fullLine = input.nextLine();
//			System.out.println(fullLine);
//			int[] lineArray = convert(fullLine);
//			System.out.println(Arrays.toString(lineArray));
//
//		}
//	}
//	public static int[] convert(String fullLine) {
//		int counter = 1;
//		int lineLength = fullLine.length();
//		Scanner input = new Scanner(fullLine);
//		int [] lineArray = new int[fullLine.length()];
//		while (input.hasNext()) {
//			for (int j = lineLength - 1; j > -1; j--) {
//				lineArray[fullLine.length() - counter] = input.charAt(j) - 48;
//				counter++;
//			}
//		}
//		return lineArray;
//	}
//
//}