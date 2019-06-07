package com.programming.boyermore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoyerMoreImpl {

	private static String filePath = "D:\\Programming-Practice\\lorem_ipsum.txt";

	public static void main(String[] args) {
		File loremIpsumFile = new File(filePath);
		String loremIpsumText = readFile(loremIpsumFile);
		String pattern = "feugiat";
		System.out.println("Find Pattern In File : ");
		List<Integer> matchIndex = boyerMoreSearch(loremIpsumText, pattern);
		for (Integer integer : matchIndex) {
			System.out.println("i : " + integer);
		}
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

	private static List<Integer> boyerMoreSearch(String text, String pattern) {
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int patternLength = patternArr.length - 1;
		Map<Character, Integer> patternMap = new HashMap<>();
		List<Integer> matchIndex = new ArrayList<>();
		for (int i = 0; i < patternArr.length; i++) {
			char c = patternArr[i];
			int charValue = patternLength - i - 1;
			patternMap.put(c, (charValue > 1 ? charValue : 1));
		}
		int i = 0;
		while (i < textArr.length) {
			int textIndex = i + patternLength;
			if (textIndex >= textArr.length) {
				break;
			}
			if (textArr[textIndex] == patternArr[patternLength]) {
				int j = patternLength;
				int k = textIndex;
				boolean isMatched = true;
				while (k > i) {
					if (textArr[k] != patternArr[j]) {
						isMatched = false;
						break;
					}
					k--;
					j--;
				}
				if (isMatched) {
					matchIndex.add(i);
				}
				i++;
			} else if (patternMap.containsKey(textArr[textIndex])) {
				i += patternMap.get(textArr[textIndex]);
			} else {
				i += patternLength;
			}
		}
		return matchIndex;

	}

}
