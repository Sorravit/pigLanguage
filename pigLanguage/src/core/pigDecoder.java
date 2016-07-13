package core;

import java.util.Arrays;

public class pigDecoder {
	public static void main(String[] args) {
		// String pigLanguage =
		// "ÍÙê´ÍÙê´ÍÙê´æææÍÙê´æÍÙê´æÍÙê´ÍÙê´ÍÙê´ÍÙê´ÍÙê´æææÍÙê´ÍÙê´æÍÙê´ææÍÙê´ÍÙê´ÍÙê´æææÍÙê´ææÍÙê´ÍÙê´ÍÙê´";
		// String input = pigLanguage.replaceAll("ÍÙê´", "1").replaceAll("æ","0");
		// StringBuilder sb = new StringBuilder();
		// Arrays.stream(input.split("(?<=\\G.{12})") // Splits the input string
		// // into
		// // 8-char-sections for english and 12 for Thai
		// ).forEach(s -> // Go through each 8-char-section...
		// sb.append((char) Integer.parseInt(s, 2)) // ...and turn it into an
		// int
		// // and then to a char
		// );
		//
		// String output = sb.toString(); // Output text (t)
		// System.out.println(output);
	}

	public String decode(String p) {
		String bin = toBin(p);
		StringBuilder sb = new StringBuilder();
		Arrays.stream(bin.split("(?<=\\G.{12})")).forEach(s -> sb.append((char) Integer.parseInt(s, 2)));
		return sb.toString();
	}

	public String toBin(String s) {
		return s.replaceAll("ÍÙê´", "1").replaceAll("æ","0");
	}
}