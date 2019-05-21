package com.programming.avltree;

import java.util.Random;

public class AvlTreeSample {

	public static void main(String[] args) {
		AvlBalancedTree<Integer> avlBalancedTree = new AvlBalancedTree<>();
		Random randomNo = new Random();
		for (int i = 0; i < 10; i++) {
			Integer random = randomNo.nextInt(100000);
			System.out.println("randomNo.nextInt(100000) : "+random);
			avlBalancedTree.insert(random);
		}
		
		avlBalancedTree.traverse();		
	}

}
