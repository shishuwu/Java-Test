package jasons.algo.arr;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Remove Element
 * 
 * <pre>
        Given an array and a value, remove all the instances of that value in the array. 
        Also return the number of elements left in the array after the operation.
        It does not matter what is left beyond the expected length.
        
        Example:
        If array A is [4, 1, 1, 2, 1, 3]
        and value elem is 1, 
        
        then new length is 3, and A is now [4, 2, 3]
        
        Try to do it in less than linear additional space complexity.
 * </pre>
 * 
 * 
 * @author shishu
 */
public class RemoveElement {
    public int removeElement(ArrayList<Integer> A, int B) {
        int count = 0;

        for (int i = 0; i < A.size(); i++) {

            if (A.get(i) == B) {
                count++;
            }
            else {
                // 占掉被挤出去的位置
                // [1, 2, 3] remove 2
                // [1], then [1, 3]
                A.set(i - count, A.get(i));
                
            }

        }

        for (int i = 0; i < count; i++)
            A.remove(A.size() - 1);

        return A.size();
    }

    @Test
    public void test() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        int b = 2;

        removeElement(list, b);
    }
}
