package com.jasons.algo.findOne;

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
public class Find1In3 {
    // DO NOT MODIFY THE LIST
    public int singleNumber(final List<Integer> a) {
        int[] bits = new int[32];

        for (int num : a) {
            // count each number -> 
            // suppose 3: ... 0000 0000 0011 (from right to left)
            for (int i = 0; i < 32; i++) {
                bits[i] += (1 & (num >> i));
                bits[i] %= 3;
            }
        }

        int number = 0;
        // bits = [1,1, 0] from right to left
        for (int i = 31; i >= 0; i--) {
            number = number * 2 + bits[i];
        }
        return number;
    }

    // ========================= Solution 2 ==========================
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int xthrees = 0;
        for (int i = 0; i < A.length; i++) {
            twos ^= (ones & A[i]);
            ones ^= A[i];
            xthrees = ~(ones & twos);
            twos &= xthrees;
            ones &= xthrees;
        }
        return ones;
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
 * 要求复杂度为O(n),而且不能用额外的内存空间。
 * 
 * 这个比之前那个Single Number I 难多了。。在网上搜的答案都看了半天才看懂。。
 * 
 * 因为十进制的数字在计算机中是以二进制的形式存储的，所以数组中的任何一个数字都可以转化为类似101001101这样的形式，int类型占内存4个字节，
 * 也就是32位。那么，如果一个数字在数组中出现了三次，比如18，二进制是10010，所以第一位和第四位上的1，也都各出现了3次。
 * 
 * 因此可以用ones代表只出现一次的数位，twos代表出现了两次的数位，xthrees代表出现了三次的数位。
 *
 */
