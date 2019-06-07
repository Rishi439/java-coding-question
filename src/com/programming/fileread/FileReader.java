package com.programming.fileread;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;

public class FileReader implements Runnable {

	private File file;

	private int minLimit;

	private int maxLimit;

	private BlockingQueue<String> queue;

	public FileReader(File file, int minLimit, int maxLimit, BlockingQueue<String> queue) {
		super();
		this.file = file;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.queue = queue;
	}

	@Override
	public void run() {
		try (FileInputStream stream = new FileInputStream(file)) {
			byte[] readFile = new byte[maxLimit - minLimit];
			StringBuffer buffer = new StringBuffer();
			while (stream.read(readFile, minLimit, maxLimit) != -1) {
				buffer.append(new String(readFile));
			}
			System.out.println("File Added ");
			queue.add(buffer.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
