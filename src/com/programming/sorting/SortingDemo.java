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
		int[] unsortedArray1 = new int[sizeOfArray];

		List<Integer> unsortedList = new ArrayList<>();
		for (int i = 0; i < sizeOfArray; i++) {
			int randomNumber = random.nextInt();
			unsortedArray[i] = randomNumber;
			unsortedArray1[i] = randomNumber;
			unsortedList.add(unsortedArray[i]);
		}
		/*
		 * Selection Sort
		 */
		Sorting selectionSort = new SelectionSort(unsortedArray);
		long selection_timeTaken_1 = System.currentTimeMillis();
		int[] selectionSortedArray = selectionSort.sort();
		long selection_timeTaken_2 = System.currentTimeMillis();
		System.out.println(
				selectionSort.getSortingType() + " Time Taken : " + (selection_timeTaken_2 - selection_timeTaken_1));
		printArray(selectionSortedArray);

		// Insertion Sort
		Sorting insertionSort = new InsertionSort(unsortedArray1);
		long insertion_timeTaken_1 = System.currentTimeMillis();
		int[] insertionSortedArray = insertionSort.sort();
		long insertion_timeTaken_2 = System.currentTimeMillis();
		System.out.println(
				insertionSort.getSortingType() + " Time Taken : " + (insertion_timeTaken_2 - insertion_timeTaken_1));
		printArray(insertionSortedArray);

		// Bubble Sort
//		Sorting bubbleSort = new BubbleSort(unsortedArray);
//		long bubble_timeTaken_1 = System.currentTimeMillis();
//		int[] bubbleSortedArray = bubbleSort.sort();
//		long bubble_timeTaken_2 = System.currentTimeMillis();
//		System.out.println(bubbleSort.getSortingType() + " Time Taken : " + (bubble_timeTaken_2 - bubble_timeTaken_1));
//		printArray(bubbleSortedArray);

		// Java Sort
		long time_taken_3 = System.currentTimeMillis();
		Collections.sort(unsortedList);
		long time_taken_4 = System.currentTimeMillis();
		System.out.println("Default  Sort: " + (time_taken_4 - time_taken_3));
		for (int i : unsortedList) {
			System.out.print(i + " | ");
		}
		scanner.close();

	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " | ");
		}
		System.out.println();

	}

}
