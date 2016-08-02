package core;

public class pigEncoder {
	public static String encode(String s) {
		String bin = toBin(s);
		String pigLanguage = bin.replaceAll("1", "���").replaceAll("0", "�");
		return pigLanguage;
	}

	private static String toBin(String s) {
		String bin = new String();
		for (int i = 0; i < s.length(); i++) {
			bin += String.format("%12s", Integer.toBinaryString((int) s.toCharArray()[i])).replace(" ", "0");
		}
		return bin;
	}
}
