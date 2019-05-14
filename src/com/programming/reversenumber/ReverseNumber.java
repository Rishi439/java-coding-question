package com.programming.reversenumber;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number you want to reverse : ");
		int numberTobeReversed = scanner.nextInt();
		int noOfDigits = ((int) Math.log10(numberTobeReversed)) + 1;
		int[] digits = new int[noOfDigits];
		int getDigits = numberTobeReversed;
		int i = 0;
		while (getDigits != 0) {
			int remainder = getDigits % 10;
			digits[i++] = remainder;
			getDigits /= 10;
		}
		int k = 0;
		for (int j = 0; j < digits.length; j++) {
			k = (k * 10) + digits[j];
		}
		System.out.println(k);
		scanner.close();
	}

}
