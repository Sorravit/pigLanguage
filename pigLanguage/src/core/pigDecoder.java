package core;

import java.util.Arrays;

public class pigDecoder {

	public String decode(String p) {
		String bin = toBin(p);
		StringBuilder sb = new StringBuilder();
		Arrays.stream(bin.split("(?<=\\G.{12})")).forEach(s -> sb.append((char) Integer.parseInt(s, 2)));
		return sb.toString();
	}

	public String toBin(String s) {
		return s.replaceAll("���", "1").replaceAll("�","0");
	}
}