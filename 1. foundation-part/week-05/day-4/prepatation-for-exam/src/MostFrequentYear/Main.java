package MostFrequentYear;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// Create a function `getMostFrequentYear` which takes the name of a CSV file as a parameter,
		// - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
		// and returns the year (as a String) when the most births happened.
		// If there were multiple years with the same number of births then return any of them.
		// If the given file doesn't exist, the function should return "File not found"

		String filePath =
			"C:\\Users\\Monika\\greenfox\\buchtikovam\\week-05\\day-4\\" +
			"prepatation-for-exam\\src\\MostFrequentYear\\births.txt";
		System.out.println(getMostFrequentYear(filePath)); // should print "2006" or "2016"
		System.out.println(getMostFrequentYear("blah"));
	}

	private static String getMostFrequentYear(String filepath) {

		try {
			Path path = Paths.get(filepath);
			List<String> lines = Files.readAllLines(path);

			String allText = String.join("\n", lines);
			String[] rows = {};
			String[] parts = {};
			String year = "";
			HashMap<String, Integer> yearOccurrences = new HashMap<>();

			rows = allText.split("\n");

			for (String row : rows) {
				parts = row.split(";");
				year = parts[1].substring(0, 4);

				if (! yearOccurrences.containsKey(year)) {
					yearOccurrences.put(year, 1);
				} else {
					yearOccurrences.put(year, yearOccurrences.get(year) + 1);
				}
			}

			return Collections.max(yearOccurrences.entrySet(), Map.Entry.comparingByValue()).getKey();

		} catch (NoSuchFileException e) {
			return "File not found";

		} catch (IOException e) {
			return "Error reading the file";
		}
	}
}