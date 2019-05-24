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

		List<Integer> unsortedList = new ArrayList<>();

		for (int i = 0; i < sizeOfArray; i++) {
		    int randomNumber = random.nextInt(10000);
			unsortedList.add(randomNumber);
		}
		System.out.println("Unsorted List : ");
		printArray(convertToArray(unsortedList));

		// bubbleSort(convertToArray(unsortedList));
		// insertionSort(convertToArray(unsortedList));
		// selectionSort(convertToArray(unsortedList));
		quickSort(convertToArray(unsortedList));
		binaryInsertionSort(convertToArray(unsortedList));
		defaultSort(unsortedList);
		scanner.close();

	}

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " | ");
		}
		System.out.println();

	}

	private static void bubbleSort(int[] unsortedArray) {
		// Bubble Sort
		Sorting bubbleSort = new BubbleSort(unsortedArray);
		long bubble_timeTaken_1 = System.currentTimeMillis();
		int[] bubbleSortedArray = bubbleSort.sort();
		long bubble_timeTaken_2 = System.currentTimeMillis();
		System.out.println(bubbleSort.getSortingType() + " Time Taken : " + (bubble_timeTaken_2 - bubble_timeTaken_1));
		printArray(bubbleSortedArray);
	}

	private static void insertionSort(int[] unsortedArray) {
		// Insertion Sort
		Sorting insertionSort = new InsertionSort(unsortedArray);
		long insertion_timeTaken_1 = System.currentTimeMillis();
		int[] insertionSortedArray = insertionSort.sort();
		long insertion_timeTaken_2 = System.currentTimeMillis();
		System.out.println(
				insertionSort.getSortingType() + " Time Taken : " + (insertion_timeTaken_2 - insertion_timeTaken_1));
		printArray(insertionSortedArray);
	}

	private static void selectionSort(int[] unsortedArray) {
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
	}

	private static void quickSort(int[] unsortedArray) {
		Sorting quickSort = new QuickSort(unsortedArray);
		long quick_timeTaken_1 = System.currentTimeMillis();
		int[] quickSortedArray = quickSort.sort();
		long quick_timeTaken_2 = System.currentTimeMillis();
		System.out.println(quickSort.getSortingType() + " Time Taken : " + (quick_timeTaken_2 - quick_timeTaken_1));
		printArray(quickSortedArray);
	}

	private static void defaultSort(List<Integer> unsortedList) {
		// Java Sort
		long time_taken_3 = System.currentTimeMillis();
		Collections.sort(unsortedList);
		long time_taken_4 = System.currentTimeMillis();
		System.out.println("Default  Sort: " + (time_taken_4 - time_taken_3));
		for (int i : unsortedList) {
			System.out.print(i + " | ");
		}
	}

	private static void binaryInsertionSort(int[] unsortedArray) {
		Sorting binaryInsertionSort = new BinaryInsertionSort(unsortedArray);
		long binaryInsertionSortStartTime = System.currentTimeMillis();
		int[] binaryInsertionSortedArray = binaryInsertionSort.sort();
		long binaryInsertionSortEndTime = System.currentTimeMillis();
		System.out.println(binaryInsertionSort.getSortingType() + " Time Taken : "
				+ (binaryInsertionSortEndTime - binaryInsertionSortStartTime));
		printArray(binaryInsertionSortedArray);
	}

	private static int[] convertToArray(List<Integer> unsortedList) {
		int[] unsortedArray = new int[unsortedList.size()];
		for (int i = 0; i < unsortedList.size(); i++) {
			unsortedArray[i] = unsortedList.get(i);
		}
		return unsortedArray;
	}

}
