package com.programming.sorting;

public abstract class Sorting {

	protected int[] arr;

	protected String sortingType;

	public Sorting(int[] arr, String sortingType) {
		super();
		this.arr = arr;
		this.sortingType = sortingType;
	}

	public abstract int[] sort();

	public void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " | ");
		}
        System.out.print("");
	}

	public String getSortingType() {
		return sortingType;
	}

}
