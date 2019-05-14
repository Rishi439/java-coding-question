package com.programming.removeduplicate;

import java.util.Random;
import java.util.Scanner;

public class RemoveDuplicate {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number of Elements In Array : ");
		int numberOfElements = scanner.nextInt();
		System.out.println("Enter multiple for duplicate :");
		int multipleForDuplicate = scanner.nextInt();
		int[] elements = new int[numberOfElements];

		for (int i = 0; i < numberOfElements; i++) {
			int randomElemts = random.nextInt();
			elements[i] = randomElemts;
			if (i % multipleForDuplicate == 0) {
				elements[i++] = randomElemts;
			}
		}
		System.out.println(removeDuplicateElements(elements, numberOfElements));
		scanner.close();
	}

	public static int removeDuplicateElements(int arr[], int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		for (int i : arr) {
			System.out.println("duplicate : " + i);
		}
		System.out.println("---------------------------------------");
		DuplicateElemnts[] temp = new DuplicateElemnts[n];
		int j = 0;

		outer: for (int i = 0; i < arr.length; i++) {

			for (DuplicateElemnts duplicateElemnts : temp) {
				if (duplicateElemnts != null) {
					if (duplicateElemnts.getNumber() == arr[i]) {
						duplicateElemnts.addDuplicate(i);
						continue outer;
					}
				}

			}
			temp[j++] = new DuplicateElemnts(arr[i]);
		}

		int[] nonDuplicateArr = new int[j];
		int i = 0;
		for (DuplicateElemnts duplicateElemnts : temp) {
			if (duplicateElemnts != null) {
				nonDuplicateArr[i++] = duplicateElemnts.getNumber();
			}
		}
		for (int k : nonDuplicateArr) {
			System.out.println("Non Duplicte : " + k);
		}

		return i;
	}

	private static class DuplicateElemnts {

		private int number;

		private int[] dumplicateElemtntsIndex;

		private int count;

		public DuplicateElemnts(int number) {
			this.number = number;
			this.dumplicateElemtntsIndex = new int[20];
		}

		public void addDuplicate(int index) {
			dumplicateElemtntsIndex[count++] = index;
		}

		public int getNumber() {
			return number;
		}

		public int[] getDumplicateElemtntsIndex() {
			return dumplicateElemtntsIndex;
		}

	}

}
