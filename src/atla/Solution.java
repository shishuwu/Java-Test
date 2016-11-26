package atla;

import java.util.Arrays;

import org.junit.Test;

/*
 * @(#)Solution.java 1.0 Dec 31, 2015
 *
 * Copyright 2015 HP Inc. All rights reserved.
 * HP PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * 
 * 
 * @auhor Jason Shi 8:16:28 PM
 * @since HPDM 4.7.1
 */
public class Solution {
    static int getIntegerComplement(int n) {
        // 光是 ~n全部取反， 前面所有为0没必要计算在内
        return ~n & ((1 << (32 - Integer.numberOfLeadingZeros(n))) - 1);
    }

    @Test
    public void test() throws Exception {
        System.out.println(Integer.toBinaryString(50));
        
        int result = getIntegerComplement(50);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }

    static int kDiffernce(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }

        Arrays.sort(a);

        int count = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] - a[j] == k) {
                    count++;
                    //break;
                }
            }
        }

        return count;
    }

    @Test
    public void test1() throws Exception {
        int a[] = { 1, 5, 3, 4, 2 };
        System.out.println(kDiffernce(a, 2));
        ;
    }

    static int numberOfPaths(int[][] a, int M, int N) {
        int n = a.length - 1;

        if (M == n && N == n)
            return 1;

        if (M > n || N > n)
            return 0;

        if (a[M][N] == 0)
            return 0;

        if (M + a[M][N] / 10 == M + a[M][N] % 10
            && M + a[M][N] % 10 == M + a[M][N] / 10)
            return numberOfPaths(a, M + a[M][N] / 10, N + a[M][N] % 10);
        else
            return numberOfPaths(a, M + a[M][N] / 10, N + a[M][N] % 10)
                   + numberOfPaths(a, M + a[M][N] % 10, N + a[M][N] / 10);
    }

    static int numberOfPaths2(int[][] a, int M, int N) {
        int m = a.length;
        int n = a[0].length;

        if (M == m - 1 && N == n - 1 || a[M][N] == 0)
            return a[M][N];
        else if (M == m - 1)
            return numberOfPaths(a, M, N + 1);
        else if (N == n - 1)
            return numberOfPaths(a, M + 1, N);
        else if (a[M][N] == 1)
            return numberOfPaths(a, M + 1, N) + numberOfPaths(a, M, N + 1);
        else
            return 0;

    }
}
