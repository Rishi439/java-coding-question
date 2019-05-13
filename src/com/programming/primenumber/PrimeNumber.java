package com.programming.primenumber;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number Till Prime Number We Can Get : ");
		int primeNumberLimit = scanner.nextInt();
		int[] numberList = new int[primeNumberLimit];

		for (int i = 0; i < primeNumberLimit; i++) {
			numberList[i] = i;
		}
		int[] primeNumberArr = findPrimeNumber(numberList, primeNumberLimit);
		primeNumberArr = Arrays.stream(primeNumberArr).filter(x -> x > 0).toArray();
		System.out.println("primeNumberArr : " + primeNumberArr.length);
		printArray(primeNumberArr);
		scanner.close();
	}

	private static int[] findPrimeNumber(int[] numberList, int primeNumberLimit) {
		for (int i = 0; i < primeNumberLimit; i++) {
			if (numberList[i] > 0) {
				int checkPrimeNumber = numberList[i];
				for (int j = 2; j < checkPrimeNumber; j++) {
					if (checkPrimeNumber % j == 0) {
						numberList[i] = -1;
					}
				}
			}
		}
		return numberList;
	}

	private static void printArray(int[] fibonacciLimit) {
		for (int i : fibonacciLimit) {
			System.out.print(i + " - ");
		}
		System.out.println();
	}

}
