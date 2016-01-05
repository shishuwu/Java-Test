package com.jasons.algo.arr.exist;

import java.util.ArrayList;

/**
 * Given an array �A� of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * 
 * <pre>
        Example:
        
        Input :
            A : [1 3 5] 
            k : 4
        Output : YES
        
        as 5 - 1 = 4
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem
        
        Try doing this in less than linear space complexity.
 * </pre>
 * 
 * @author shishu
 *
 */
public class ExitSubValue {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int start, end;
        int n = A.size();
        int diff;

        start = 0;
        end = 1;

        while (start <= end && end < n) {

            diff = A.get(end) - A.get(start);

            if (diff == B && start != end) {
                return 1;
            }
            else if (diff <= B) {
                end++;
            }
            else {
                start++;
            }
        }

        return 0;
    }
}
