package com.programming.palindrome;

import java.util.Scanner;

public class IntegerPalindrome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number To Check Palindrome : ");
		int palindromeNumber = scanner.nextInt();
		int reversedPalindrome = 0;
		int remainder = 0;
		int getDigits = palindromeNumber;
		boolean isPalindrome = false;
		while (getDigits != 0) {
			remainder = getDigits % 10;
			reversedPalindrome = reversedPalindrome * 10 + remainder;
			getDigits /= 10;
		}
		System.out.println("reversedPalindrome : " + reversedPalindrome);
		if (reversedPalindrome == palindromeNumber) {
			isPalindrome = true;
		}

		System.out.println("Is " + palindromeNumber + " palindrome : " + isPalindrome);
		scanner.close();
	}

}
