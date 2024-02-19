import java.io.IOException;
import java.nio.file.*;

public class CopyFile {
	// Write a `copy` function that copies the contents of a file into another file.
	// The function should take two filenames (strings) as parameters:
	//  - path and name of the source file
	//  - path and name of the target file
	// It should return a boolean that shows whether the copy was successful or not.
	public static void main(String[] args) throws IOException {
		String initialPath = "file1.txt";
		String targetPath = "file2.txt";

		copy(initialPath, targetPath);
	}

	public static boolean copy(String sourcePath, String destinationPath) throws IOException {
		Files.copy(Paths.get(sourcePath),
			Files.newOutputStream(Paths.get(destinationPath)));
		return true;
	}
}
