package com.programming.linkedlist;

import java.util.Random;

public class MiddleItemLinkedList {

	public static void main(String[] args) {
		CustomLinkedList<Integer> integerLinkedList = new CustomLinkedList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int randomNo = random.nextInt();
			System.out.println("Count : " + i + " | Value : " + randomNo);
			integerLinkedList.add(randomNo);
		}
		System.out.println("====================================");
		int i = 0;

		for (Integer integer : integerLinkedList) {
			i++;
			System.out.println("Count : " + i + " | Value : " + integer);
		}

		System.out.println("-------------------------------------------------");

		LinkedList1<Integer> integerLinkedList1 = new LinkedList1<>();
		for (int j = 0; j < 10; j++) {
			int randomNo = random.nextInt();
			System.out.println("Count : " + j + " | Value : " + randomNo);
			integerLinkedList1.add(randomNo);
		}
		System.out.println("====================================");
		int k = 0;

		for (Integer integer : integerLinkedList1) {
			k++;
			System.out.println("Count : " + k + " | Value : " + integer);
		}

	}
}
