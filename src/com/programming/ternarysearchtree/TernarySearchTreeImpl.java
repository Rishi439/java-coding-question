package com.programming.ternarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

public class TernarySearchTreeImpl {

	public static void main(String[] args) {
		Faker faker = Faker.instance();
		TernarySearchTree<Integer> ternarySearchTree = new TernarySearchTree<>();
		List<String> getFile = new ArrayList<>();
		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			String dummyText = faker.team().name();
//			dummyText = dummyText.replaceAll(" ", "");
//			int dummyNo = random.nextInt();
//			ternarySearchTree.insert(dummyText, dummyNo);
//			getFile.add(dummyText);
//		}
		
		String dummyText = faker.team().name();
		dummyText = dummyText.replaceAll(" ", "");
		int dummyNo = random.nextInt();
		ternarySearchTree.insert(dummyText, dummyNo);
		getFile.add(dummyText);

		for (String string : getFile) {
			System.out.println("Key : " + string);
			System.out.println("Values : " + ternarySearchTree.getValue(string));
		}
	}

}
