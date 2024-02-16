public class TodoPrint {
	public static void main(String... args){
		String todoText = " - Buy milk\n";

		// Add "My todo:" to the beginning of the `todoText`
		// Add " - Download games" to the end of the `todoText`
		// Add " - Diablo" to the end of the `todoText` applying an extra 4 space indention

		// Expected output:

		// My todo:
		//  - Buy milk
		//  - Download games
		//      - Diablo
		todoText = "My todo:\n" + todoText;
		todoText = todoText.concat(" - Download games\n     - Diablo");

		System.out.println(todoText);
	}
}