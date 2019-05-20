package com.programming.temp.practice;

import java.util.Scanner;

public class Sample1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string from where quoates to be stripped : ");
		String htmlText = null;
		while (scanner.hasNext()) {
			String tempText = scanner.nextLine();
			if (!tempText.equalsIgnoreCase("quit")) {
				htmlText += tempText;
			} else {
				break;
			}
		}
		htmlText = htmlText.replaceAll("\"", "\\\\\"");
		System.out.println("HTML Text 0: " + htmlText);
		//replaceAll("\\'", "\\\\'");
		htmlText = htmlText.replaceAll("'", "\\\\\\\'");
		System.out.println("HTML Text 1: " + htmlText);
		scanner.close();
	}

}
