package com.programming.sorting;

public class SelectionSort extends Sorting {

	public SelectionSort(int[] arr) {
		super(arr , "Selection Sort");
	}

	@Override
	public int[] sort() {
		// TODO Auto-generated method stub
		return selectionSort(arr, 0);
	}

	private int[] selectionSort(int[] unsortedArray, int index) {
		int lowestIndex = findLowest(unsortedArray, Integer.MAX_VALUE, index, 0);
		if (lowestIndex < unsortedArray[index]) {
			int lowestValue = unsortedArray[lowestIndex];
			unsortedArray[lowestIndex] = unsortedArray[index];
			unsortedArray[index] = lowestValue;
		}
		if (index == (unsortedArray.length - 1)) {
			return unsortedArray;
		}
		index += 1;
		return selectionSort(unsortedArray, index);
	}

	private int findLowest(int arr[], int currentLowest, int index, int currentLowestIndex) {
		if (currentLowest > arr[index]) {
			currentLowest = arr[index];
			currentLowestIndex = index;
		}

		if (index == arr.length -1) {
			return currentLowestIndex;
		}
		index += 1;
		return findLowest(arr, currentLowest, index, currentLowestIndex);

	}

}
