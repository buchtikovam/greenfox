package RemoveSwearWords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		String fileName =
			"C:\\Users\\Monika\\greenfox\\buchtikovam\\week-05\\day-4\\" +
			"prepatation-for-exam\\src\\RemoveSwearWords\\content1.txt";

		int removedWords = removeSwearWords(fileName);
		System.out.println("Removed " + removedWords + " swear words.");
	}

	public static int removeSwearWords(String fileName) throws IOException {

		Path filePath = Paths.get(fileName);
		List<String> lines = Files.readAllLines(filePath);
		int removedWords = 0;

		String[] swearWords = {
			"fuck", "bloody", "cock", "shit",
			"fucker", "fuckstick", "asshole",
			"dick", "piss", "cunt"
		};

		List<String> badWordsList = new ArrayList<>(Arrays.asList(swearWords));
		List<String> filteredLines = new ArrayList<>();

		// going through all lines of input, splitting it into Arraylist of Strings
		for (String line : lines) {
			String[] wordsArray = line.split(" ");
			List<String> wordList = new ArrayList<>(Arrays.asList(wordsArray));
			List<String> filteredList = new ArrayList<>();

			// going through all strings in string array, removing punctuation + filtering swear words
			for (String word : wordList) {
				String cleanedWord = removePunctuation(word);
				if (!badWordsList.contains(cleanedWord.toLowerCase())) {
					filteredList.add(word);
				} else {
					removedWords++;
				}
			}

			// joing arraylist of strings to one string
			String filteredLine = String.join(" ", filteredList);
			filteredLines.add(filteredLine);
		}

		// rewriting input file
		Files.write(filePath, filteredLines);
		return removedWords;
	}

	// helper method
	private static String removePunctuation(String word) {
		return word.replaceAll("[.,!?]", "");
	}
}