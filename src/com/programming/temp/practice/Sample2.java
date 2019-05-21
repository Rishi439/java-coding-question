package com.programming.temp.practice;

import java.util.Scanner;

public class Sample2 {

	static void miniMaxSum(int[] arr) {

		System.out.println(findMinimum(arr, 0, Long.MAX_VALUE) + " " + findMaximum(arr, 0, Long.MIN_VALUE));
	}

	private static long findMinimum(int[] arr, int index, long minimum) {
		if (index > arr.length - 1) {
			return minimum;
		} else {
			long minimumValue = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i != index) {
					minimumValue += arr[i];
				}
			}

			index += 1;
			System.out.println("Index : " + index + " | Minimum : " + minimum + " | Minimum Value : " + minimumValue);
			return findMinimum(arr, index, (minimumValue < minimum ? minimumValue : minimum));
		}
	}

	private static long findMaximum(int[] arr, int index, long maximum) {
		if (index > arr.length - 1) {
			return maximum;
		} else {
			long maximumValue = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i != index) {
					maximumValue += arr[i];
				}
			}
			index += 1;
			System.out.println("Index : " + index + " | Maximum : " + maximum + " | Maximum Value : " + maximumValue);
			return findMaximum(arr, index++, (maximumValue > maximum ? maximumValue : maximum));
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);

		scanner.close();
	}

}
