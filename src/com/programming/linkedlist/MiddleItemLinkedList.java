package com.programming.linkedlist;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MiddleItemLinkedList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of elements in linked list : ");
		int numOfElements = scanner.nextInt();
		Random randomGen = new Random();
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < numOfElements; i++) {
			linkedList.add(randomGen.nextInt());
		}

		scanner.close();
	}

}
