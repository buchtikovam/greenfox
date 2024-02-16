package LogsExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		// Write a method `getUniqueIpAddresses` which accepts a path to `log.txt`
		// as a parameter and returns an array of unique IP addresses.
		// Write a method `getRequestRatio` which accepts a path to `log.txt`
		// as a parameter and returns the ratio of GET to POST requests.
		// If the specified file cannot be found the methods should return an empty
		// array and 0.0 respectively (and raise no errors).
		// Change the path of the log.txt source file to the path
		// where you saved it on your computer.
		// You can find the source file in a link next to this exercise.

		String filePath = "C:\\Users\\Monika\\greenfox\\buchtikovam\\week-05\\day-4\\prepatation-for-exam\\src\\Logs\\log.txt";
		System.out.println(String.join(System.lineSeparator(), getUniqueIpAddresses(filePath)));

		System.out.println(
			"The ratio of POST and GET request is: " +
			getRequestRatio(filePath)
		);
	}

	public static List<String> getUniqueIpAddresses(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		List<String> uniqueIPAddresses = new ArrayList<>();

		for (String line : lines) {
			String IPAddress = line.substring(27, 38);
			if (! uniqueIPAddresses.contains(IPAddress)) {
				uniqueIPAddresses.add(IPAddress);
			}
		}

		return uniqueIPAddresses;
	}

	public static double getRequestRatio(String filePath) throws IOException {
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		int getRequestCount = 0;
		int postRequestCount = 0;

		if (lines.isEmpty()) {
			return 0.0;
		}

		for (String line : lines) {
			if (line.contains("GET /")) {
				getRequestCount++;
			}

			if (line.contains("POST /")) {
				postRequestCount++;
			}
		}

		return (double) getRequestCount / postRequestCount;
	}
}