import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class WriteSingleLine {
	public static void main(String[] args) {
		// Write a program in the `main` method that is able to manipulate a file
		// by writing your name into it as a single line.
		// The file should be named "my-file.txt".
		// In case the program is unable to write the file,
		// it should print the following error message: "Unable to write file: my-file.txt".
		String myFile = "my-file.txt";
		Path filePath = Paths.get(myFile);
		ArrayList<String> names = new ArrayList<>();
		names.add("Monika");
		try {
			Files.write(filePath, names);
		} catch (IOException e) {
			System.out.println("Unable to write file: " + myFile);
		}
	}
}