package CountLetters;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {
	private static final int maxChar = 256;

	public Map<Character, Integer> getCharOccurrence(String s1) {
		int[] count = new int[maxChar];
		int length = s1.length();
		char[] ch = new char[length];

		for (int i = 0; i < length; i++) {
			count[s1.charAt(i)]++;
		}

		Map<Character, Integer> result = new HashMap<>();

		for (int i = 0; i < length; i++) {
			ch[i] = s1.charAt(i);
			int find = 0;

			for (int j = 0; j <= i; j++) {
				if (s1.charAt(i) == ch[j]) find++;
			}

			if (find == 1) {
				result.put(s1.charAt(i), count[s1.charAt(i)]);
			}
		}

		return result;
	}
}
