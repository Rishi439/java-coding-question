package com.programming.squareroot;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number To Find Square Root : ");
		int number = scanner.nextInt();
		System.out.println("Square Root Of : " + number + " is " + findSquareRoot(number));
		scanner.close();
	}

	private static double findSquareRoot(int number) {
		double temp;

		double sr = number / 2;
		do {
			temp = sr;
			sr = (temp + (number / temp)) / 2;
		} while ((temp - sr) != 0);

		return sr;
	}

}
