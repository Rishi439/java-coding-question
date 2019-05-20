package com.programming.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SortingDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of items in array : ");
		int sizeOfArray = scanner.nextInt();
		Random random = new Random();
		int[] unsortedArray = new int[sizeOfArray];
		List<Integer> unsortedList = new ArrayList<>();
		for (int i = 0; i < sizeOfArray; i++) {
			unsortedArray[i] = random.nextInt();
			unsortedList.add(unsortedArray[i]);
		}
		Sorting sort = new SelectionSort(unsortedArray);
		long timeTaken_1 = System.currentTimeMillis();
		int[] sortedArray = sort.sort();
		long timeTaken_2 = System.currentTimeMillis();
		System.out.println(sort.getSortingType() + " Time Taken : " + (timeTaken_2 - timeTaken_1));
		long time_taken_3 = System.currentTimeMillis();
		Collections.sort(unsortedList);
		long time_taken_4 = System.currentTimeMillis();
		System.out.println("Default  Sort: " + (time_taken_4 - time_taken_3));

		printArray(sortedArray);

		System.out.println("Sorted Array : ");
		for (int i : unsortedList) {
			System.out.print(i + " | ");
		}
		scanner.close();

	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " | ");
		}

	}

}
