package com.programming.repeatedcharacter;

import java.util.Arrays;
import java.util.Scanner;

public class RepeatedCharacter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String Find Repeated Character : ");
		String repeatedString = scanner.nextLine().trim();

		char[] repeatedChar = repeatedString.toCharArray();
		RepeatedChar[] repeatedCharClass = new RepeatedChar[repeatedChar.length];
		int i = 0;
		outer: for (char c : repeatedChar) {

			for (RepeatedChar repeatedChar2 : repeatedCharClass) {
				if (repeatedChar2 != null) {
					if (c == repeatedChar2.getC()) {
						repeatedChar2.addCount();
						continue outer;
					}
				}

			}
			repeatedCharClass[i++] = new RepeatedChar(c);
			i++;
		}

		repeatedCharClass = (RepeatedChar[]) Arrays.stream(repeatedCharClass).filter((x) -> x.getCount() > 1).toArray();
		char[] finalCharArray = new char[repeatedCharClass.length];
		int ij = 0;
		for (RepeatedChar repeatedCharValue : repeatedCharClass) {
			finalCharArray[ij++] = repeatedCharValue.getC();
		}

		scanner.close();
	}

	private static class RepeatedChar {

		private char c;

		private int count;

		public RepeatedChar(char c) {
			super();
			this.c = c;
		}

		public void addCount() {
			count++;
		}

		public char getC() {
			return c;
		}

		public int getCount() {
			return count;
		}

	}

}
