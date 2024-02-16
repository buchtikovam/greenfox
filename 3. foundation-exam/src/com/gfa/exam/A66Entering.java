package com.gfa.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class A66Entering {

	public static void main(String[] args) throws IOException {
		System.out.println(
			getMainDoorUsage(
				"com/gfa/exam/logs.csv"
			)
		);
	}

	public static HashMap<String, Integer> getMainDoorUsage(String filename) throws IOException {

		if (filename == null) {
			throw new IllegalArgumentException();
		}

		HashMap<String, Integer> chipOccurrences = new HashMap<>();

		try {
			Path path = Paths.get(filename);
			List<String> lines = Files.readAllLines(path);

			String allText = String.join("\n", lines);
			String[] rows, parts = {};
			String currentDoor = "";
			String currentChip = "";

			String door = "A66 - 04 FÕBEJÁRAT (F-1) Door #1";

			rows = allText.split("\n");

			for (String row : rows) {
				parts = row.split(",");
				currentDoor = parts[5];
				currentChip = parts[12];

				if (currentDoor.equals(door)) {

					if (!chipOccurrences.containsKey(currentChip)) {
						chipOccurrences.put(currentChip, 1);

					} else {
						chipOccurrences.put(
							currentChip,
							chipOccurrences.get(currentChip) + 1
						);
					}
				}
			}

		} catch (NoSuchFileException e) {
			System.out.println("File not found");
		}

		return chipOccurrences;
	}
}