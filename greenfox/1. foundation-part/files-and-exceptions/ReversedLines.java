import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// Create a method called `decryptReversed` that takes a filename string
// as a parameter and decrypts the file's content.
// Decryption is the process reversing an encryption, i.e. the process
// which converts encrypted data into its original form.
// If the file can't be opened it should print this message: "File not found"
// The (decrypted) result should be saved in the "output.txt" file (don't change the path).
// Change the path of the reversed-lines.txt source file to the path
// where you saved it on your computer.
// You can find the source file in a link next to this exercise.
public class ReversedLines {
	public static void main(String[] args) {
		decryptReversed("reversed-lines.txt");
	}

	private static void decryptReversed(String location) {
		Path filePath = Paths.get(location);
		List<String> decryptedLines = new ArrayList<>();

		try {
			List<String> lines = Files.readAllLines(filePath);

			for (String line : lines) {
				StringBuilder reversedLine = new StringBuilder(line);
				reversedLine.reverse();
				decryptedLines.add(reversedLine.toString());
			}

			Files.write(Paths.get("output.txt"), decryptedLines);
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
}
