package com.programming.sorting;

public class BubbleSort extends Sorting {

	private int count;

	private int index;

	public BubbleSort(int[] sortingArray) {
		super(sortingArray, "Bubble Sort");
	}

	public int[] sort() {
		arr = bubblesort(arr, 0, 0, false);

		return arr;
	}

	private int[] bubblesort(int[] sortingArray, int index, int sortedCount, boolean isSorted) {

		if (index == sortingArray.length) {
			index = 0;
			sortedCount++;
		}
		if ((index + 1) < sortingArray.length) {
			if (sortingArray[index] > sortingArray[index + 1]) {
				int value = sortingArray[index];
				sortingArray[index] = sortingArray[index + 1];
				sortingArray[index + 1] = value;
			}
		}
		if (sortedCount == sortingArray.length - 1) {
			return sortingArray;
		}
		index += 1;
		return bubblesort(sortingArray, index, sortedCount, isSorted);
	}

}
