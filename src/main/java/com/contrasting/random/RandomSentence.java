package com.contrasting.random;

public class RandomSentence {

	private RandomSentence() {
	}

	private static RandomSentence instance;

	public static String getSentence() {
		if (instance == null) {
			instance = new RandomSentence();
		}
		int sentenceLength = RandomIntGenerator_.get(10);
		StringBuffer output = new StringBuffer();
		output.append(getFirstWord() + " ");
		for (int i = 0; i < sentenceLength; i++) {
			output.append(getCleanWord() + " ");
		}
		String sentence = output.toString().trim();
		if (sentence.length() > 255) {
			sentence = sentence.substring(0, 255);
		}
		sentence = sentence + ". ";
		return sentence;
	}

	private static Object getFirstWord() {
		String word = getCleanWord();
		return upLow(word);
	}

	private static String getCleanWord() {
		String word = "fantastic";
		for (int i = 0; i < 10; i++) {
			word = RandomWord.getWord();
			if (word.endsWith("-") || word.endsWith(".")) {
				continue;
			} else {
				break;
			}
		}
		return word;
	}

	private static String upLow(String var) {
		if (var == null | var.equals("")) {
			return " ";
		}
		String start = var.substring(0, 1);
		String finish = var.substring(1, var.length()).toLowerCase();
		return start.toUpperCase() + finish;
	}
}
