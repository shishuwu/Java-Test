package com.jasons.algo.string;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement strStr().
 * 
 * <pre>
 *      strstr - locate a substring ( needle ) in a string ( haystack ).
 *      
 *      
 *      
 *      
        Try not to use standard library string functions for this question.

        Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
        
        NOTE:
        
        Good clarification questions:
        
        What should be the return value if the needle is empty?
        What if both haystack and needle are empty?
        - For the purpose of this problem, assume that the return value should be -1 in both cases.
 * </pre>
 * 
 * @author shishu
 *
 */
public class FindStrInStr {

	/**
	 * <pre>
	 * x: how are you doing?
	 * y: are
	 * 
	 * -> 4
	 * 
	 * </pre>
	 */
	public int strStr(final String haystack, final String needle) {
		// cursor
		char[] full = haystack.toCharArray();
		int fullLen = full.length;

		char[] sub = needle.toCharArray();
		int subLen = sub.length;

		for (int i = 0; i < fullLen - subLen + 1; i++) {
			char[] tempsub = Arrays.copyOfRange(full, i, i + subLen);
			// if (Arrays.equals(tempsub, sub)) {
			if (this.equals(tempsub, sub)) {
				return i;
			}
		}
		return -1;
	}

	public boolean equals(char[] a, char[] b) {
		if (a == null && b == null) {
			return true;
		}
		if (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Test
	public void test() throws Exception {
		FindStrInStr test = new FindStrInStr();
		// Assert.assertSame(-1, test.strStr("bbbbbbbbab", "baba"));
		Assert.assertSame(1, test.strStr("aaba", "ab"));
		Assert.assertSame(0, test.strStr("b", "b"));
	}
}
