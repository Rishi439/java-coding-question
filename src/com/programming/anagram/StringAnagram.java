package com.programming.anagram;

import java.util.Scanner;

public class StringAnagram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Check if string is anagram 0.1: ");
		String anagramStringCheck1 = scanner.nextLine().trim();
		System.out.println("Check if string is anagram 1: ");
		String anagramStringCheck2 = scanner.nextLine().trim();
		boolean isAnagram = true;
		outer: for (char anagramChar1 : anagramStringCheck1.toCharArray()) {
			boolean isMAtched = false;
			for (char anagramChar2 : anagramStringCheck2.toCharArray()) {
				if (anagramChar1 == anagramChar2) {
					isMAtched = true;
				}
			}
			if (!isMAtched) {
				isAnagram = false;
				break outer;
			}
		}
		if (!isAnagram) {
			System.out.println(anagramStringCheck1 + " is not anagram with " + anagramStringCheck2);
		} else {
			System.out.println(anagramStringCheck1 + " is anagram with " + anagramStringCheck2);
		}
	}

}
