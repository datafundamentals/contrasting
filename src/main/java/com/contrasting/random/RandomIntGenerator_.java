package com.contrasting.random;

public class RandomIntGenerator_ {
	protected static int max;

	/**
	 * CAUTION this returns a one based bottom limit, not a zero based bottom
	 * limit - in other words a number between 1 and max
	 * 
	 * @param max
	 * @return
	 */
	public static synchronized int get(int max) {
		double aDouble = Math.random();
		aDouble = aDouble * max;
		int zeroBasedInt = (int) aDouble;
		return zeroBasedInt + 1;
		
	}

}
