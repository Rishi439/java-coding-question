package com.programming.factorial;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Integr To Find Factorial");
		int factorialNo = scanner.nextInt();
		System.out.println("Factorial Of " + factorialNo + " is : " + findFactorial(factorialNo, 1));
		scanner.close();

	}

	private static int findFactorial(int number, int totalNumber) {
		if (number > 0) {
			totalNumber *= number;
			return findFactorial(--number, totalNumber);
		} else {
			return totalNumber;
		}
	}

}
