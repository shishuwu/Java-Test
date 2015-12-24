package com.jasons.algo;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * <pre>
        You may assume no duplicates in the array.
        
        Here are few examples.
        
        [1,3,5,6], 5 → 2
        [1,3,5,6], 2 → 1
        [1,3,5,6], 7 → 4
        [1,3,5,6], 0 → 0
 * </pre>
 * 
 * @author shishu
 */
public class Insertpos {
    // ================Solution 1==================================
    public int searchInsert(ArrayList<Integer> a, int b) {
        if (a == null || a.size() == 0) {
            return 0;
        }

        for (int i = 0; i < a.size(); i++) {
            if (b == a.get(i)) {
                return i;
            }
            if (b < a.get(i)) {
                if (i == 0) {
                    return 0;
                }
                return i - 1;
            }
        }
        return a.size();
    }

    // ==================Solution 2 ====================================

    private int result = -1;

    private ArrayList<Integer> list;
    private int value;

    public int searchInsert2(ArrayList<Integer> a, int b) {
        list = a;
        value = b;
        travel(0, a.size() - 1);
        return result;
    }

    private void travel(int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            if (list.get(start) == value) {
                result = start;
            }
            else if (list.get(start) > value) {
                result = start - 1;
                if(result < 0){
                    result = 0;
                }
            }
            else {
                result = start + 1;
            }
            return;
        }

        int mid = start + (end - start) / 2;
        if (list.get(mid) == value) {
            result = mid;
        }
        else if (list.get(mid - 1) < value && list.get(mid) > value) {
            result = mid;
            return;
        }
        else if (list.get(mid) < value && list.get(mid + 1) > value) {
            result = mid + 1;
            return;
        }

        else if (list.get(mid) > value) {
            travel(start, mid - 1);
        }
        else if (list.get(mid) < value) {
            travel(mid + 1, end);
        }
    }

    @Test
    public void test() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(3);
//        list.add(5);

        int index = new Insertpos().searchInsert2(list, 1);
        System.out.println(index);
    }
}

// ===============
/**
 * <pre>
 * Thought:
 *  Key points: ordered list.
 *  
 *  Solution 1: brute force ... loop all element
 *      * find first element = input value
 *              return index
 *      * find first element > input value
 *              return index -1
 *  
 *  
 *  Solution 2: So it could abstract to x try to insert to 3 elements
 *      x -> [a, b, c]
 * 
 * </pre>
 */
