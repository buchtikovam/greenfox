import java.util.HashMap;
import java.util.Map.Entry;
public class MapIntroduction2 {
	public static void main(String[] args) {
		HashMap<String, String> myHashmap = new HashMap<>();
		myHashmap.put("978-1-60309-452-8", "A Letter to Jo");
		myHashmap.put("978-1-60309-459-7", "Lupus");
		myHashmap.put("978-1-60309-444-3", "Red Panda and Moon Bear");
		myHashmap.put("978-1-60309-461-0", "The Lab");

		for (String key: myHashmap.keySet()) {
			System.out.println(myHashmap.get(key) + " (ISBN: " + key + ")");
		}

		myHashmap.remove("978-1-60309-444-3");
		String value = "978-1-60309-461-0";

		for (Entry<String, String> entry : myHashmap.entrySet()) {
			if (entry.getValue() == value) {
				myHashmap.remove(entry.getKey());
				break;
			}
		}

		myHashmap.put("978-1-60309-450-4", "They Called Us Enemy");
		myHashmap.put("978-1-60309-453-5", "Why Did We Trust Him?");

		System.out.println(myHashmap.containsKey("478-0-61159-424-8"));
		System.out.println(myHashmap.get("978-1-60309-453-5"));
	}
}
