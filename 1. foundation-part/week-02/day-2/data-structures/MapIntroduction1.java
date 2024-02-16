import java.util.HashMap;

public class MapIntroduction1 {
	public static void main(String[] args) {
		HashMap<Integer, String> myHashmap = new HashMap<>();
		System.out.println(myHashmap.isEmpty());
		myHashmap.put(97, "a");
		myHashmap.put(98, "b");
		myHashmap.put(99, "c");
		myHashmap.put(65, "A");
		myHashmap.put(66, "B");
		myHashmap.put(67, "C");
		System.out.println(myHashmap.keySet());
		System.out.println(myHashmap.values());

		myHashmap.put(68, "D");

		System.out.println(myHashmap.size());
		System.out.println(myHashmap.get(99));

		myHashmap.remove(97);

		System.out.println(myHashmap.containsKey(100));

		myHashmap.clear();

		System.out.println(myHashmap.size());
	}
}
