public class SarcasmCase {
	public static void main(String[] args) {
		String sentence = "unicorns are real";
		System.out.println(sarcasm(sentence));
	}
	public static String sarcasm(String message) {
		String r = "";
		for (int i = 0; i < message.length(); i++) {
			if (i % 2 == 0) {
				r += message.substring(i, i + 1).toUpperCase();
			} else {
				r += message.substring(i, i + 1);
			}
		}
		return r;
	}
}

/* THE AI PART:

	prompt: write me a method in Java, that converts every other character
	of given string to uppercase. The string should be called "sentence"
	and the method "Sarcasm"

	AI CODE:

public class SarcasmConverter {
    public static String Sarcasm(String sentence) {
        StringBuilder sarcasticSentence = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            // Check if the character should be converted to uppercase based on its index (0-based).
            if (i % 2 == 0) {
                sarcasticSentence.append(Character.toLowerCase(currentChar));
            } else {
                sarcasticSentence.append(Character.toUpperCase(currentChar));
            }
        }

        return sarcasticSentence.toString();
    }

    public static void main(String[] args) {
        String inputSentence = "This is a sample sentence.";
        String sarcasticResult = Sarcasm(inputSentence);
        System.out.println(sarcasticResult);
    }
}
 */