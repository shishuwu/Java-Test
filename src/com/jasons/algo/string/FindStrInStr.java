package com.jasons.algo.string;

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

        for (int i = 0; i < fullLen - subLen; i++) {

        }
    }
}
