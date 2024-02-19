import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class CountLines {
// Write a function called countLines() that takes a filename as string as a parameter
// and returns the number of lines the file contains.
// It should return zero if it can't open the file and should not raise any error.

	public static void main(String[] args) {

		int numberOfLines = countLines("my-file.txt"); //my-file.txt is automatically a string
		System.out.println(numberOfLines);
	}

	public static int countLines (String path){
		Path filePath = Paths.get(path);
		try {
			List<String> arrayList = Files.readAllLines(filePath); //Files.readAllLines is automatically a list
			return arrayList.size();
		} catch (IOException e) {
			return 0;
		}
	}
}