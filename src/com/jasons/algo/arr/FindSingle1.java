package com.jasons.algo.arr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given an array of integers, every element appears thrice except for one which
 * occurs once.
 * 
 * <pre>
        Find that element which does not appear thrice.
        
        Note: Your algorithm should have a linear runtime complexity.
        
        Could you implement it without using extra memory?
        
        Example :
        
        Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
        Output : 4
 * </pre>
 * 
 * 
 */
public class FindSingle1 {
    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int[] bits;
        bits = new int[32];

        for (int num : a) {

            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }

        }

        int number = 0;

        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }

        return number;

    }
    
    @Test
    public void test() throws Exception {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(1);
        a.add(1);
        System.out.println(singleNumber(a));
    }
}
/**
 * Let us look at every bit position.
 * 
 * Every number that occurs thrice will either contribute 3 ‘1’s or 3 ‘0’s to
 * the position.
 * 
 * The number that occurs once X will contribute exactly one 0 or 1 to the
 * position depending on whether it has 0 or 1 in that position.
 * 
 * So:
 * 
 * <pre>
        If X has 1 in that position, we will have (3x+1) number of 1s in that position.
        If X has 0 in that position, we will have (3x+1) number of 0s in that position.
 * </pre>
 * 
 * Can you think of a solution using the above observation?
 *
 */

