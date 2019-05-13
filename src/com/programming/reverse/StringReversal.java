package com.programming.reverse;

import java.util.Scanner;

public class StringReversal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String To Be Reversed : ");
		String stringToBeReversed = scanner.nextLine().trim();
		char[] charArray = stringToBeReversed.toCharArray();
		System.out.println("Reversed String Is : " + reverseStringRecursive(charArray, new char[charArray.length], 0));
		scanner.close();
	}

	private static String reverseString(String reverseString) {
		char[] charArray = reverseString.toCharArray();
		char[] charArrayReverse = new char[charArray.length];
		int j = 0;
		for (int i = charArray.length - 1; i >= 0; i--) {
			char c = charArray[i];
			charArrayReverse[j] = c;
			j++;

		}
		return new String(charArrayReverse);
	}

	private static String reverseStringRecursive(char[] charArray, char[] charArrayReverse, int count) {
		if (charArray.length == count) {
			return new String(charArrayReverse);
		} else {
			charArrayReverse[count] = charArray[charArray.length - 1 - count];
			count++;
			return reverseStringRecursive(charArray, charArrayReverse, count);
		}
	}

}
