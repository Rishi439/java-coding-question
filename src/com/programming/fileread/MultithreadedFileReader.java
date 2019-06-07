package com.programming.fileread;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedFileReader {

	private static String filePath = "D:\\Programming-Practice\\100MB.txt";

	public static void main(String[] args) {
		File file = new File(filePath);
		List<Integer> fileLenght = new ArrayList<>();
		int initialSize = (int) (file.length() / 16);
		System.out.println("Initial Size : " + initialSize);
		System.out.println("Real Size : " + (file.length() / 16));
		System.out.println("File Size : " + file.length());
		for (int i = 0; i < 16; i++) {
			fileLenght.add(initialSize);
			if (initialSize == file.length()) {
				break;
			}
			if ((initialSize * 2) < file.length()) {
				initialSize *= 2;
			} else {
				initialSize = (int) file.length();
			}
		}
		BlockingQueue<String> readString = new ArrayBlockingQueue<>(fileLenght.size() + 1, true);
		ExecutorService executerService = Executors.newCachedThreadPool();
		for (int i = 0; i < fileLenght.size(); i++) {
			int minLimit = (i < 0 ? fileLenght.get(i - 1) : 0);
			executerService.submit(new FileReader(file, minLimit, fileLenght.get(i), readString));
		}
		try {
			executerService.awaitTermination(10L, TimeUnit.SECONDS);

			for (String string : readString) {
				System.out.println("String : " + string);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
