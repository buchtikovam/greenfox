import java.util.ArrayList;

public class ShoppingList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("eggs");
		list.add("milk");
		list.add("fish");
		list.add("apples");
		list.add("bread");
		list.add("chicken");

		if (list.contains("milk")) {
			System.out.println("yes");
		} else System.out.println("no");

		if (list.contains("bananas")) {
			System.out.println("yes");
		} else System.out.println("no");
	}
}
