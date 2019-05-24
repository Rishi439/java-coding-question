package com.programming.sorting;

public class BinaryInsertionSort extends Sorting {

	public BinaryInsertionSort(int[] arr) {
		super(arr, "Binary Insertion Sort");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] sort() {
		binaryInsertionSort(1);
		return arr;
	}

	private void binaryInsertionSort(int index) {
		// 30 | 64 | 310 | 342 | 297 | 465 | 336 | 593 | 725 | 778 |
		int findGreatesIndex = findGreatestIndex(0, (index > 0 ? index - 1 : index), 0, arr[index]);
		if (findGreatesIndex >= 0) {
			if (arr[index] < arr[findGreatesIndex]) {
				shiftArray(findGreatesIndex, arr[index], index);
			}
		}
		index += 1;
		if (index <= (arr.length - 1)) {
			binaryInsertionSort(index);
		}

	}

	private int findGreatestIndex(int lowestIndex, int highestIndex, int maxIndex, int value) {
		int middleIndex = findMiddle(lowestIndex, highestIndex);
		boolean isRecursive = false;
		if (arr[lowestIndex] < value && arr[middleIndex] > value) {
			maxIndex = middleIndex;
			highestIndex = middleIndex;
			isRecursive = true;
		} else if (arr[middleIndex] < value && arr[highestIndex] > value) {
			maxIndex = highestIndex;
			lowestIndex = middleIndex;
			isRecursive = true;
		}

		if (arr[maxIndex] > value) {
			if (maxIndex == 0) {
				return maxIndex;
			} else if (arr[maxIndex - 1] < value) {
				return maxIndex;
			}
		}
		if (isRecursive) {
			return findGreatestIndex(lowestIndex, highestIndex, maxIndex, value);
		} else {
			return -1;
		}

	}

	private int findMiddle(int lowerIndex, int higherIndex) {
		return (lowerIndex + (higherIndex - lowerIndex) / 2);
	}

	private void shiftArray(int biggerIndex, int value, int index) {
		if (biggerIndex <= index) {
			int tempValue = arr[biggerIndex];
			arr[biggerIndex] = value;
			biggerIndex += 1;
			shiftArray(biggerIndex, tempValue, index);

		}

	}

}
