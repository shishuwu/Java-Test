package com.jasons.algo.arr;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given an array of integers, every element appears twice except for one which
 * occurs once.
 * 
 * <pre>
        Find that element which does not appear twice.
        
        Note: Your algorithm should have a linear runtime complexity.
        
        Could you implement it without using extra memory?
        
        Example :
        
        Input : [1, 1, 2, 2, 4, 4, 8, 8, 5]
        Output : 5
 * </pre>
 * 
 * @author shishu
 */
public class Find1in2n {

    public int singleNumber(final List<Integer> a) throws Exception {
        if (a == null || a.isEmpty()) {
            throw new Exception("list is empty");
        }

        int result = 0;
        for (Integer i : a) {
            result ^= i;
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(8);
        list.add(8);
        list.add(4);
        
        Find1in2n test = new Find1in2n();
        System.out.println(test.singleNumber(list));
    }
}

/**
 * 原理：异或
 * 
 * <pre>
 *   0 ^ B = B
 *   (A ^ A) ^ B = B
 *   A ^ (A ^ B) = B
 * </pre>
 */
