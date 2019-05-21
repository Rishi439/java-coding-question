package com.programming.binarysearchtree;

import java.util.Random;

public class BinarySearchTreeApp {

	public static void main(String[] args) {

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			binarySearchTree.insert(random.nextInt());

		}
		
		for (Integer integer : binarySearchTree) {
			System.out.println("Value : "+integer);
		}

	}

}
