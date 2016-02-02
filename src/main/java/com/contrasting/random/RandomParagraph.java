package com.contrasting.random;

public class RandomParagraph {
	
	private RandomParagraph(){
	}
	
	private static RandomParagraph instance;

	public static String getParagraph() {
		return getParagraph(4);
	}
	public static String getParagraph(int sentenceCount) {
		int length = 4;
		if(sentenceCount>0&&sentenceCount<4){
			length = sentenceCount;
		}
		StringBuffer output = new StringBuffer();

		if(instance==null){
			instance = new RandomParagraph();
		}
		for(int i = 0;i<length;i++){
			output.append(RandomSentence.getSentence());
		}
		String paragraph = output.toString().trim();
        if(paragraph.length()>255){
        	paragraph = paragraph.substring(0,255);
        }
		return paragraph;
		
	}

}
