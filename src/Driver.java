import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	// Main Method
	public static void main(String[] args) throws FileNotFoundException {
		int length = findSizeOfDictionary("Dictionary.txt");
		String[] dictionary = new String[length];
		dictionary = readFile("Dictionary.txt", length);
		spellcheck(dictionary);
	}

	// Method that counts how many words are in the dictionary.
	public static int findSizeOfDictionary(String fileName) throws FileNotFoundException {
		int fileLength = 0;
		Scanner file = new Scanner(new File(fileName));
		while (file.hasNextLine()) {
			fileLength++;
			file.nextLine();
		}
		return fileLength;
	}

	// Method that assigns each word to a element in the dictionary array.
	public static String[] readFile(String filename, int fileSize) throws FileNotFoundException {
		String fileName = "Dictionary.txt";
		Scanner file = new Scanner(new File(fileName)); 
		String[] dictionary = new String[fileSize];	
		for(int count = 0; count <= fileSize - 1; count++) {
			dictionary [count] = file.nextLine();
		}
		file.close();
		return dictionary;
	}

	// Method that spellchecks each word the user inputs.
	public static void spellcheck(String[] dictionary) {
		System.out.println("Enter a word or QUIT to stop:");
		Scanner scan = new Scanner(System.in);
		String keyboard = scan.next();
		while (!(keyboard.equals("QUIT")) && !(keyboard.equals("quit"))) {
			int index = Arrays.binarySearch(dictionary, keyboard);
			if (index >= 0) {
				System.out.println("That word is spelled correctly");
				System.out.println("Enter a word or QUIT to stop:");
				keyboard = scan.next();
			}
			else if (index < 0) {
				System.out.println("That word is not spelled correctly");
				System.out.println("Enter a word or QUIT to stop:");
				keyboard = scan.next();
			}
		}
	}
}