package com.programming.fibonacci;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Number For Fibonacci Series :");

		int fibonacciNo = scanner.nextInt();
		int[] fibonacciArray = new int[fibonacciNo];
		if (fibonacciNo > 0) {
			findFibonacciNo(fibonacciArray, 0);

		}
		scanner.close();
	}

	private static void findFibonacciNo(int[] fibonacciLimit, int count) {

		if (count == 0) {
			fibonacciLimit[count] = 1;
			fibonacciLimit[++count] = 1;
			findFibonacciNo(fibonacciLimit, count);
		} else if (count + 1 < fibonacciLimit.length) {
			int fibonacciNo = fibonacciLimit[count] + fibonacciLimit[count - 1];
			fibonacciLimit[++count] = fibonacciNo;
			findFibonacciNo(fibonacciLimit, count);
		} else {
			printArray(fibonacciLimit);
		}
	}

	private static void printArray(int[] fibonacciLimit) {
		for (int i : fibonacciLimit) {
			System.out.print(i + " - ");
		}
		System.out.println();
	}

}
