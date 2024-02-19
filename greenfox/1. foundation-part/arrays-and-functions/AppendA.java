import java.lang.reflect.Array;
import java.util.Arrays;

public class AppendA {
	public static void main(String[] args) {
		// - Create an array variable named `animals`
		//   with the following content:
		//   `["koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr",
		//     "gorill", "hyen", "hydr", "iguan", "impal", "pum", "tarantul",
		//     "piranh"]`
		//
		// - Add an `"a"` at the end of all elements (use a loop!)
		// - Print the 'fixed' array to the console:
		//   [koala, panda, zebra, anaconda, boa, ..., puma, tarantula, piranha]
		String[] animals = {
				"koal", "pand", "zebr", "anacond", "bo", "chinchill", "cobr",
				"gorill", "hyen", "hydr", "iguan", "impal", "pum", "tarantul",
				"piranh"
		};

		for (int i = 0; i < animals.length; i++) {
			animals[i] += "a";
		}

		System.out.print(Arrays.toString(animals));
	}
}