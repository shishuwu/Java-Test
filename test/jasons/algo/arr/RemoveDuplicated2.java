package jasons.algo.arr;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Remove Duplicates from Sorted Array
 * 
 * <pre>
        Given a sorted array, remove the duplicates in place such that each element appear atmost twice and return the new length.
        
        Do not allocate extra space for another array, you must do this in place with constant memory.
        
        Note that even though we want you to return the new length, make sure to change the original array as well in place
        
        For example,
        Given input array A = [1,1,1,2],
        
        Your function should return length = 3, and A is now [1,1,2].
 * </pre>
 * 
 * @author shishu
 *
 */
public class RemoveDuplicated2 {
    public int removeDuplicates(ArrayList<Integer> list) {
        int index = 1;
        int count = 1;
        int n = list.size();

        for (int i = 1; i < n; i++) {
            if (list.get(i).intValue() == list.get(i - 1).intValue() && count < 2) {
                list.set(index, list.get(i));
                count++;
                index++;
            }
            else if (list.get(i).intValue() != list.get(i - 1).intValue()) {
                list.set(index, list.get(i));
                count = 1;
                index++;
            }
        }

        return index;
    }
    
    @Test
    public void test() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        
        removeDuplicates(list);
    }
}
