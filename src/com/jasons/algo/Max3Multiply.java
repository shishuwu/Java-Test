package com.jasons.algo;

import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, return the highest product possible by
 * multiplying 3 numbers from the array
 * 
 * Input:
 * 
 * array of integers e.g {1, 2, 3} NOTE: Solution will fit in a 32-bit signed
 * integer Example:
 * 
 * [0, -1, 3, 100, 70, 50]
 * 
 * => 70*50*100 = 350000
 * 
 * @author shishu
 *
 */
public class Max3Multiply {

	public int maxp3(List<Integer> a) {
		if (a.size() < 3) {
			return 0;
		}

		Collections.sort(a);

		int tempMax = a.get(a.size() - 1) * a.get(a.size() - 2) * a.get(a.size() - 3);
		int tempMax2 = a.get(a.size() - 1) * a.get(0) * a.get(1);

		return Math.max(tempMax, tempMax2);
	}
}

/**
 * Access Hint Choosing 3 maximum elements in the array and 2 negative elements
 * with the highest absolute value should be enough.
 * 
 * There are various ways to calculate 3 maximum elements in the array ( and
 * subsequently 2 negative elements with highest absolute value ). One such
 * approach is maintaining 3 variables ( m1, m2, m3 where m1 > m2 > m3 ). When
 * you encounter new value in the array, if the value is less than m3, then the
 * variables are unaffected. Else, depending on where the new value lies, you
 * can update the 3 values.
 * 
 * Another approach could be maintaining a priority_queue of size 3. You pop out
 * the smallest element if the new element if bigger than the smallest element,
 * and then insert the new element into the priority queue.
 * 
 * Once you have the 5 elements you desire, your answer would be one of the
 * following : 1) Product of 3 maximum elements 2) Product of the 2 negative
 * elements with max absolute value and maximum positive value.
 */
