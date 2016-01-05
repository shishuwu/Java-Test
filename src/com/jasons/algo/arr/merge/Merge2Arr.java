package com.jasons.algo.arr.merge;

import java.util.ArrayList;

/**
 * 
 * @author shishu
 */
public class Merge2Arr {
    public void merge2(ArrayList<Integer> A, ArrayList<Integer> B) {
        int aLen, bLen;
        ArrayList<Integer> res = new ArrayList<>();

        if (A == null && B == null)
            return;

        if (A == null) {
            A = B;
            return;
        }

        if (B == null)
            return;

        aLen = A.size();
        bLen = B.size();

        int indexA, indexB;
        int k = 0;

        for (indexA = 0, indexB = 0; k < aLen + bLen; k++) {
            if (indexA >= aLen)
                res.add(B.get(indexB++));
            else if (indexB >= bLen)
                res.add(A.get(indexA++));
            else if (A.get(indexA) <= B.get(indexB)) {
                res.add(A.get(indexA));
                indexA++;
            }
            else {
                res.add(B.get(indexB));
                indexB++;
            }
        }

        A.clear();

        for (int num : res)
            A.add(num);

        return;

    }

    // ============================================
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a == null && b == null) {
            return;
        }
        if (a == null) {
            a = b;
            return;
        }
        if (b == null) {
            return;
        }

        int indexA = 0;
        int indexB = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (indexA < a.size() && indexB < b.size()) {
            if (a.get(indexA) < b.get(indexB)) {
                result.add(a.get(indexA));
                indexA++;
            }
            
            else if (b.get(indexB) < a.get(indexA)) {
                result.add(b.get(indexB));
                indexB++;
            }
            else if (b.get(indexB) == a.get(indexA)) {
                result.add(b.get(indexB));
                result.add(a.get(indexA));
                indexA++;
                indexB++;
            }
        }
        a.clear();
        for (Integer i : result) {
            a.add(i);
        }
    }
}
