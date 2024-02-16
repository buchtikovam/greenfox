package Anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {
	@Test
	public void testIsAnagram() {
		Anagram anagram = new Anagram();
		assertTrue(anagram.isAnagram("rac", "car"));
	}

}