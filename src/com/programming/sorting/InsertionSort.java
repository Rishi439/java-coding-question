package com.programming.sorting;

public class InsertionSort extends Sorting {

	public InsertionSort(int[] arr) {
		super(arr, "Insertion Sort");
	}

	@Override
	public int[] sort() {
		return insertionSort(arr, 1);
	}

	private int[] insertionSort(int[] unsortedArray, int index) {
		if (index <= unsortedArray.length - 1) {
			int biggerIndex = biggerBeforeIndex(unsortedArray, index);
			if (biggerIndex >= 0) { // replace value of index with any value bigger than it , before its position i
									// array
				int tempValue = unsortedArray[biggerIndex];
				unsortedArray[biggerIndex] = unsortedArray[index];
				shiftArray(unsortedArray, biggerIndex + 1, tempValue, index);
			}

			index += 1;
			return insertionSort(unsortedArray, index);
		} else {
			return unsortedArray;
		}
	}

	/*
	 * Fetch any big value before index
	 */
	private int biggerBeforeIndex(int[] unsortedArray, int index) {
		int lowestValue = Integer.MAX_VALUE;
		int lowestIndex = -1;
		for (int i = 0; i < index; i++) {
			if (unsortedArray[index] < unsortedArray[i]) {
				if (unsortedArray[i] < lowestValue) {
					lowestIndex = i;
					lowestValue = unsortedArray[i];
				}
			}
		}
		return lowestIndex;
	}

	private void shiftArray(int[] unsortedArray, int biggerIndex, int value, int index) {
		if(biggerIndex <= index) {
			int tempValue = unsortedArray[biggerIndex];
			unsortedArray[biggerIndex] = value;
			biggerIndex +=1;
			shiftArray(unsortedArray,biggerIndex , tempValue, index);

		}

	}

}
