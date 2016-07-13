package core;

public class pigEncoder {
	public String encode(String s) {
		String bin = toBin(s);
		String pigLanguage = bin.replaceAll("1", "���").replaceAll("0", "�");
		return pigLanguage;
	}

	public String toBin(String s) {
		String bin = new String();
		for (int i = 0; i < s.length(); i++) {
			bin += Integer.toBinaryString((int) s.toCharArray()[i]);
		}
		return bin;
	}
}
