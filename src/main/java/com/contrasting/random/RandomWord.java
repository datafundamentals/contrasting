package com.contrasting.random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomWord {
	/*
	 * This class is intended for test routines and not production codebases,
	 * note the sloppy way that the RandomAccessFile is maintained as a static
	 * and never closed
	 */

	private static RandomWord instance;
	private static int wordCount = 61220;
	private static int fileLength = 666700;
	private static String filePath = "wordList.txt";
	private static RandomAccessFile file;

	private RandomWord() {
		try {
			file = new RandomAccessFile(filePath, "r");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"File not found: " + filePath + ", place in root alongside running jar?");
		}
	}

	public static String getWord() {
		if (instance == null) {
			instance = new RandomWord();
		}
		long start = (long) RandomIntGenerator_.get(fileLength);
		String output = null;
		try {
			file.seek(start);
			file.readLine();
			output = file.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return output;
	}

}
