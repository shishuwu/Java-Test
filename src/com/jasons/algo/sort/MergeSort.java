package com.jasons.algo.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * divide and conquer
 * 
 * <pre>
 *  Build Model
 *  	- Merge 2 sorted array into 1 sorted array.
 * 
 * </pre>
 * 
 * @author shishu
 *
 */
public class MergeSort {

	public int[] sort(int[] input) {
		if (input.length <= 1)
			return input;
		if (input.length == 2) {
			if (input[0] > input[1]) {
				int temp = input[0];
				input[0] = input[1];
				input[1] = temp;
			}
			return input;
		}
		int mid = input.length / 2;

		int[] firstHalf = sort(getPart(input, 0, mid));

		int[] secondHalf = sort(getPart(input, mid + 1, input.length - 1));

		return mergePart(firstHalf, secondHalf);
	}

	/**
	 * Merge 2 array into 1 ordered array.
	 * 
	 * @param firstHalf
	 * @param secondHalf
	 * @return
	 */
	private int[] mergePart(int[] firstHalf, int[] secondHalf) {
		int[] result = new int[firstHalf.length + secondHalf.length];
		// 3 cursors to 3 arrays
		int firstIndex = 0, secondIndex = 0, resultIndex = 0;
		while (resultIndex < result.length) {
			if (chooseFirstHalf(firstHalf, firstIndex, secondHalf, secondIndex))
				result[resultIndex++] = firstHalf[firstIndex++];
			else
				result[resultIndex++] = secondHalf[secondIndex++];
		}
		return result;
	}

	/**
	 * Check whether 1st index of 1st part smaller.
	 * 
	 * @param firstHalf
	 * @param firstIndex
	 * @param secondHalf
	 * @param secondIndex
	 * @return
	 */
	private boolean chooseFirstHalf(int[] firstHalf, int firstIndex, int[] secondHalf, int secondIndex) {
		if (firstIndex == firstHalf.length)
			return false;
		if (secondIndex == secondHalf.length)
			return true;
		return firstHalf[firstIndex] < secondHalf[secondIndex];
	}

	/**
	 * Copy specified part of array.
	 * 
	 * @param input
	 * @param begin
	 * @param end
	 * @return
	 */
	private int[] getPart(int[] input, int begin, int end) {
		int[] result = new int[end - begin + 1];
		for (int i = begin; i <= end; i++)
			result[i - begin] = input[i];
		return result;
	}

	// ================= Test ===============
	MergeSort mergeSort;

	@Before
	public void setUp() {
		mergeSort = new MergeSort();
	}

	@Test
	public void should_return_1_for_merge_sort_1() {
		int[] input = { 1 };
		int[] expected = { 1 };
		assertArrayEquals(expected, mergeSort.sort(input));
	}

	@Test
	public void should_return_12_for_merge_sort_21() {
		int[] input = { 2, 1 };
		int[] expected = { 1, 2 };
		assertArrayEquals(expected, mergeSort.sort(input));
	}

	@Test
	public void should_return_1234_for_merge_sort_3214() {
		int[] input = { 3, 2, 1, 4 };
		int[] expected = { 1, 2, 3, 4 };
		assertArrayEquals(expected, mergeSort.sort(input));
	}

	@Test
	public void should_return_12345_for_merge_sort_54321() {
		int[] input = { 5, 4, 3, 2, 1 };
		int[] expected = { 1, 2, 3, 4, 5 };
		assertArrayEquals(expected, mergeSort.sort(input));
	}
}
