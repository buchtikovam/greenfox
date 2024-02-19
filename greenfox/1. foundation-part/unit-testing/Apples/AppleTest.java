package Apples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppleTest {
	@Test
	public void appleGetCorrectStringValue() {
		Apple myObject = new Apple();
		assertEquals("apple", myObject.getApple());
	}
}