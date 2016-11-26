package jasons.algo.arr;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Remove duplicates from Sorted Array
 * 
 * <pre>
        Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
        
        Note that even though we want you to return the new length, make sure to change the original array as well in place
        
        Do not allocate extra space for another array, you must do this in place with constant memory.
        
        Example: 
        Given input array A = [1,1,2],
        Your function should return length = 2, and A is now [1,2].
 * </pre>
 * 
 * 
 * @author shishu
 */
public class RemoveDuplicated1 {
    public int removeDuplicates(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int len = list.size();

        int index = 1;
        int count = 1;
        
        for (int i = 1; i < len; i++) {
            if (list.get(i).intValue() == list.get(i - 1).intValue() && count < 1) {
                list.set(index++, list.get(i));
                count++;
            }
            else if (list.get(i).intValue() != list.get(i - 1).intValue()) {
                list.set(index++, list.get(i));
                count = 1;
            } 
            
            // else count >=2, the number will be replaced
        }
        return index;
    }
    
    @Test
    public void test() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(500);
        list.add(500);
        list.add(500);
        
        removeDuplicates(list);
        
    }
    
}
