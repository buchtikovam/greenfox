package CountLetters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountLettersTest {
	@Test
	public void testGetOccuranceOfEachLetter() {
		CountLetters cl = new CountLetters();
		String testString = "hello";
		assertEquals(
				"{e=1, h=1, l=2, o=1}",
				cl.getCharOccurrence("hello").toString()
		);
	}
}