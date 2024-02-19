public class FormatList {
	public static void main(String[] args) {
		String[] books = {
				"The Great Gatsby",
				"The Lord of the Rings",
				"The Lord of the Rings"
		};
		System.out.println(formatList(books));
	}
	public static String formatList(String[] ulList){
		String element = "";
		String olList = "";
		for (int i = 0; i < ulList.length; i++) {
			element = (i + 1) + ". " + ulList[i] + "\n";
			olList += element;
		}
		return olList;
	}
}

/* AI PART:
	prompt:
	create me a method in java called "formatList" which formats
	an array using a loop to the following format:
	1. (first array content)
	2. (second array content)


	code:
public class ArrayFormatter {
    public static String formatList(Object[] array) {
        StringBuilder formattedList = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            formattedList.append(i + 1).append(". ").append(array[i]);

            if (i < array.length - 1) {
                formattedList.append("\n");
            }
        }

        return formattedList.toString();
    }

    public static void main(String[] args) {
        Object[] myArray = {"First item", "Second item", "Third item"};
        String formattedList = formatList(myArray);
        System.out.println(formattedList);
    }
}
*/