package com.programming.rabinkarp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RabinKarpImpl {

	private static String filePath = "D:\\Programming-Practice\\lorem_ipsum.txt";

	public static void main(String[] args) {
		File loremIpsumFile = new File(filePath);
		String loremIpsumText = readFile(loremIpsumFile);
		String pattern = "feugiat";
		System.out.println("Find Pattern In File : ");
		findPatternInFile(loremIpsumText, pattern);
	}

	private static String readFile(File path) {

		try (FileInputStream stream = new FileInputStream(path)) {
			byte[] buffer = new byte[1024];
			StringBuffer stringBuffer = new StringBuffer();
			while (stream.read(buffer) != -1) {
				stringBuffer.append(new String(buffer));
			}
			return stringBuffer.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	private static void findPatternInFile(String text, String pattern) {
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int patternHashCode = findHashCode(patternArr);
		int i = 0;
		while (i < textArr.length) {

			char[] matcherText = new char[patternArr.length];
			int k = 0;
			for (int j = i; j < (i + patternArr.length); j++) {
				if (j < textArr.length) {
					matcherText[k] = textArr[j];
					k++;
				}
			}
			if (findHashCode(matcherText) == patternHashCode) {
				boolean isMatched = true;
				for (int m = 0; m < patternArr.length; m++) {
					char c = patternArr[m];
					char d = matcherText[m];
					if (c != d) {
						isMatched = false;
						break;
					}
				}
				if (isMatched) {
					System.out.println("Pattern Matched At : " + i + " | " + text.substring(i, i + patternArr.length));
				}
			}
			i++;
		}

	}

	private static int findHashCode(char c) {
		return (int) c;
	}

	private static int findHashCode(char[] c) {
		int hashCode = 0;
		for (char d : c) {
			hashCode += (int) d;
		}
		return hashCode;
	}

}
