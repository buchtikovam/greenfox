import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class WriteMultipleLines {
	// Create a function `writeLines` that takes 3 parameters: a path, a word and a number.
	// The function should write multiple lines into a file.

	// - The path parameter should be a string that describes the location (path & name)
	//    of the file you wish to write.

	// - The word parameter should also be a string that will be written to the file as individual lines.

	// - The number parameter should describe how many times the function should write the word in the file.

	// Example:
	// If the word is "apple" and the number is 5, it should write 5 lines
	// into the file and each of the should be "apple".
	// When the function can't write into the file, than it shall throw a RuntimeException with the
	// "Unable to write file: <path>" error message.
	public static void main(String[] args) {
		String location = "my-file.txt";
		writeLines(location, "apple", 6);
	}

	private static void writeLines(String path, String word, int multiplicator) {
		Path filePath = Paths.get(path);
		List<String> content = new ArrayList<>();
		content.add(word);
		try {
			Files.write(filePath, content);
			for (int i = 0; i < multiplicator - 1; i++) {
				Files.write(filePath, content, StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			System.out.println("Unable to write: " + path);
		}
	}
}