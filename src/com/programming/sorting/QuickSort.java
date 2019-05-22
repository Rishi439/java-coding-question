package com.programming.sorting;

public class QuickSort extends Sorting {

	public QuickSort(int[] arr) {
		super(arr, "Quick Sort ");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] sort() {
		// TODO Auto-generated method stub
		quickSort(0, arr.length - 1);
		return arr;
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = arr[findPivot(i, j)];
		while (i <= j) {

			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				exchangeNumber(i, j);
				i++;
				j--;
			}
		}

		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private int findPivot(int lowerIndex, int higherIndex) {

		return (lowerIndex + (higherIndex - lowerIndex) / 2);

	}

	private void exchangeNumber(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
