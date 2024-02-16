import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Doubled {

	public static void main(String[] args) {
		// Create a method called `decryptDoubled` that takes a filename string
		// as a parameter and decrypts the file's content.
		
		// Decryption is the process reversing an encryption, i.e. the process
		// which converts encrypted data into its original form.
		
		// If the file can't be opened it should print this message: "File not found"
		
		// The (decrypted) result should be saved in the "output.txt" file (don't change the path).
		
		// Change the path of the duplicated-chars.txt source file to the path
		// where you saved it on your computer.
		// You can find the source file in a link next to this exercise.
		decryptDoubled("duplicated-chars.txt");
	}

	private static void decryptDoubled(String location) {
		Path filePath = Paths.get(location);
		String decrypted = "";
		List<String> newList = new ArrayList<>();

		try {
			String lines = Files.readAllLines(filePath).toString();
			int n = lines.length();
			int i = 0, jump = 2;

			while (i < n) {
				decrypted += lines.charAt(i);
				i += jump;
			}
			newList.add(decrypted);
			Files.write(Paths.get("output.txt"), newList);

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
}