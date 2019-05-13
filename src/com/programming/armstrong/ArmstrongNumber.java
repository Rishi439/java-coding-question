package com.programming.armstrong;

import java.util.Arrays;
import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Check if number is armstrong : ");
		int armstrongNumber = scanner.nextInt();
		int getDigits = armstrongNumber;
		int[] nums = new int[10];
		int count = 0;
		while (getDigits != 0) {
			int remainder = getDigits % 10;
			nums[count] = remainder;
			getDigits /= 10;
			count++;
		}
		nums = Arrays.stream(nums).filter((x) -> x > 0).toArray();
		int totalNumber = 0;
		for (int i : nums) {
			totalNumber += Math.pow(i, 3);
		}

		if (armstrongNumber == totalNumber) {
			System.out.println(armstrongNumber + " is a armstrong number");
		} else {
			System.out.println(armstrongNumber + " is not a armstrong number");
		}

		scanner.close();
	}

}
