package core;

import java.util.Arrays;

public class pigDecoder {

	public static String decode(String p) {
		String bin = toBin(p);
		StringBuilder sb = new StringBuilder();
		Arrays.stream(bin.split("(?<=\\G.{12})")).forEach(s -> sb.append((char) Integer.parseInt(s, 2)));
		return sb.toString();
	}

	private static String toBin(String s) {
		return s.replaceAll("ÍÙê´", "1").replaceAll("æ","0");
	}
}