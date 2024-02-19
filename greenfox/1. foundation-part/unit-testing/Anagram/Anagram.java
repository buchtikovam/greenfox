package Anagram;

import java.util.Arrays;

public class Anagram {

	public boolean isAnagram(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		boolean result;

		if (str1.length() == str2.length()) {
			char[] charArray1 = str1.toCharArray();
			char[] charArray2 = str2.toCharArray();

			Arrays.sort(charArray1);
			Arrays.sort(charArray2);
			result = true;
		} else result = false;

		return result;
	}
}
