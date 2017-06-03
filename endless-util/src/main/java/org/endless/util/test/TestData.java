package org.endless.util.test;

import java.util.Random;

public abstract class TestData {
	public static final String[] EMAILSUFFIX = new String[] { "@qq.com", "@163.com", "@sina.com" };
	public static final char[] WORDS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static final char[] ZH_WORDS = new char[] { '你', '是', '我', '不', '落', '叶', '下', '的', '光' };

	public static final Random random = new Random();

	public static String generateEmail() {
		int len = random.nextInt(10);
		while (len < 4)
			len = random.nextInt(10);
		StringBuilder result = new StringBuilder();
		int index = 0;
		for (int i = 0; i < len; i++) {
			index = random.nextInt(WORDS.length);
			result.append(WORDS[index]);
		}
		index = random.nextInt(EMAILSUFFIX.length);
		result.append(EMAILSUFFIX[index]);

		return result.toString();
	}

	public static String generatephone() {
		int len = 10;// 手机号长度减1,第一位为1
		StringBuilder result = new StringBuilder();
		int index = 0;

		result.append("1");
		for (int i = 0; i < len; i++) {
			index = random.nextInt(10);// 前十位为数字
			result.append(WORDS[index]);
		}

		return result.toString();
	}

	public static String generaterLogin() {
		int len = random.nextInt(10);
		while (len < 4)
			len = random.nextInt(10);
		StringBuilder result = new StringBuilder();
		int index = 0;
		for (int i = 0; i < len; i++) {
			index = random.nextInt(WORDS.length);
			result.append(WORDS[index]);
		}
		return result.toString();
	}
}
