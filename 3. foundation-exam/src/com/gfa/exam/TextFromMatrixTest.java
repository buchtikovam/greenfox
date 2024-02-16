package com.gfa.exam;

import com.gfa.exam.TextFromMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextFromMatrixTest {

	@Test
	public void methodThrowsIllegalArgumentExceptionIfMatrixIsNull() {
		char[][] testMatrix = null;

		assertThrows(
			IllegalArgumentException.class,
			() -> TextFromMatrix.extractFrom(testMatrix)
		);
	}

	@Test
	public void methodShowsCorrectResultForMatrix() {
		char[][] testMatrix = {
			{'g', 'z', 'r', 'z'},
			{'z', 'e', 'z', 'e'},
			{'n', 'z', 'f', 'z'},
			{'z', 'o', 'z', 'x'}
		};

		assertEquals("greenfox", TextFromMatrix.extractFrom(testMatrix));
	}

}