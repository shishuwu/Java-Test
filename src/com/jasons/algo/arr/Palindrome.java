package com.jasons.algo.arr;

import org.junit.Test;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * <pre>
        Example:
        
        "A man, a plan, a canal: Panama" is a palindrome.
        
        "race a car" is not a palindrome.
        
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * </pre>
 * 
 * @author shishu
 *
 */
public class Palindrome {
    public int isPalindrome(String a) {
        char[] arr = a.toCharArray();
        StringBuffer buf = new StringBuffer();
        for (char c : arr) {
            // NOTE: Be aware of "alphanumeric characters"
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9')) {
                buf.append(Character.toLowerCase(c));
            }
        }

        int mid = buf.length() / 2;
        char[] format = buf.toString().toCharArray();
        int len = format.length;
        for (int i = 0; i < mid; i++) {
            if (format[i] != format[len - 1 - i]) {
                return 0;
            }
        }
        return 1;
    }


    @Test
    public void test() throws Exception {
        Palindrome test = new Palindrome();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(test.isPalindrome("race a car"));
        System.out.println(test.isPalindrome("1a2"));
    }
}

/**
 * Access Hint:
 * 
 * <pre>
 * This is a fairly simple question.

        You need to maintain 2 pointers, one from the beginning and one from the end.
        
        At every iteration, after skipping the non alphanumeric characters, both the characters should match.
        
        Have you considered empty strings?
        
        Empty strings are palindromes. This is however, a nice question for clarification from the interviewer.
        
        Note:
          Are you correctly skipping the non alphanumeric characters?
          Are you correctly handling whitespaces?
 * </pre>
 */
