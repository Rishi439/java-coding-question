package com.programming.palindrome;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String To Check If Its Palindrome : ");
		String checkingString = scanner.nextLine().trim();
		System.out.println("Is " + checkingString + " palindrome : " + isPalindrome(checkingString));
		scanner.close();
	}

	private static boolean isPalindrome(String isPalindrome) {
		isPalindrome = isPalindrome.toLowerCase().replaceAll(" ", "");
		char[] charArray = isPalindrome.toCharArray();
		int i = 0;
		int j = charArray.length - 1;
		boolean isPalindromeCheck = true;
		while (isPalindromeCheck && i < charArray.length && j > 0) {
			if (charArray[i] != charArray[j]) {
				System.out.println(charArray[i] + "(" + i + ") | (" + j + ")" + charArray[j]);
				isPalindromeCheck = false;
			} else {
				i++;
				j--;
			}

		}
		return isPalindromeCheck;
	}

}
