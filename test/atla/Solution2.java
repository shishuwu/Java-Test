package atla;

import org.junit.Test;

/**
 * Find number of valid paths from (0,0) to bottom-right in array
 * 
 * <pre>
 * Problem statement:

        You are given a two-dimensional array with M rows and N columns.
        You are initially positioned at (0,0) which is the top-left cell in the array.
        You are allowed to move either right or downwards.
        
        
        The array is filled with 1’s and 0’s. A 1 indicates that you can move through that cell, 
        a 0 indicates that you cannot move through the cell.
        Write a function ‘numberOfPaths’ which takes in the above two dimensional array, 
        return the number of valid paths from the top-left cell to the bottom-right cell (i.e. [0,0] to [M-1,N-1]).

Solution:

        A recursive solution. At each co-ordinate, attempt to move right AND down recursively. Once you reach the destination co-ordinate, increment the path-counter and return.
 * </pre>
 * 
 * @author shishu
 *
 */

/*
 * You are given a 2-Dimensional array with M rows and N columns. You are
 * initially positioned at (0,0) which is the top-left cell in the array. You
 * are allowed to move either right or downwards. The array is filled with 1's
 * and 0's. A 1 indicates that you can move through that cell, a 0 indicates
 * that you cannot move through the cell. Given a function numberOfPaths which
 * takes in the above 2-D array, return the number of paths from the top-left
 * cell to the bottom-right cell (i.e. (0,0) to (M-1,N-1)).
 */
public class Solution2 {
    /**
     * @param a
     *            The two dimensional array in which paths have to be found
     * @param i
     *            horizontal index
     * @param j
     *            vertical index
     * @param count
     *            counter to keep track of valid paths
     * @return number of valid paths found
     */
    private int numberOfPaths(int[][] a, int i, int j, int count) {

        int iMax = a.length - 1;
        int jMax = a[0].length - 1;

        // if starting point OR end point is 0,
        // you can never reach destination
        if (a[0][0] == 0 || a[iMax][jMax] == 0) {
            return 0;
        }

        // if we reached destination increment the
        // path count by one and return
        if (i == iMax && j == jMax) {
            return ++count;
        }

        // try to reach a[iMax][jMax] by moving right
        // from current co-ordinates. If we reach,
        // count will be incremented and bubbled up
        // through the recursive calls.
        if (i + 1 <= iMax && a[i + 1][j] == 1) {
            count = numberOfPaths(a, i + 1, j, count);
        }

        // try to reach a[iMax][jMax] by moving down
        // from current co-ordinates. If we reach,
        // count will be incremented and bubbled up
        // through the recursive calls.
        if (j + 1 <= jMax && a[i][j + 1] == 1) {
            count = numberOfPaths(a, i, j + 1, count);
        }

        // return the count.
        return count;
    }

    public static void main(String args[]) {
        Solution2 solution = new Solution2();

        int[][] a = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        System.out.println(
                "Expected = 2, Found = " + solution.numberOfPaths(a, 0, 0, 0));

        a = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        System.out.println(
                "Expected = 4, Found = " + solution.numberOfPaths(a, 0, 0, 0));

        a = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        System.out.println(
                "Expected = 6, Found = " + solution.numberOfPaths(a, 0, 0, 0));

        a = new int[][] { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        System.out.println(
                "Expected = 0, Found = " + solution.numberOfPaths(a, 0, 0, 0));

        a = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 0 } };
        System.out.println(
                "Expected = 0, Found = " + solution.numberOfPaths(a, 0, 0, 0));
    }

    // ================================
    int paths = 0;

    public void travel(int[][] a, int i, int j) {
        int iMax = a.length - 1;
        int jMax = a[0].length -1;

        if (a == null || a[0][0] == 0 || a[iMax][jMax] == 0) {
            return;
        }

        if (i == iMax && j == jMax && a[i][j] == 1) {
            paths++;
            return;
        }

        if ((i + 1 <= iMax) && a[i + 1][j] == 1) {
            travel(a, i + 1, j);
        }

        if ((j + 1 <= jMax) && a[i][j + 1] == 1) {
            travel(a, i, j + 1);
        }
    }

    @Test
    public void test() throws Exception {

        Solution2 solution = new Solution2();

        int[][] a = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        solution.paths = 0;
        solution.travel(a, 0, 0);
        System.out.println("Expected = 2, Found = " + solution.paths);

        a = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
        solution.paths = 0;
        solution.travel(a, 0, 0);
        System.out.println("Expected = 4, Found = " + solution.paths);

        a = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        solution.paths = 0;
        solution.travel(a, 0, 0);
        System.out.println("Expected = 6, Found = " + solution.paths);

        a = new int[][] { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        solution.paths = 0;
        solution.travel(a, 0, 0);
        System.out.println("Expected = 0, Found = " + solution.paths);

        a = new int[][] { { 1, 1, 1 }, 
                          { 1, 1, 1 }, 
                          { 1, 1, 0 } };
                          solution.paths = 0;
        solution.travel(a, 0, 0);
        System.out.println("Expected = 0, Found = " + solution.paths);

    }
}
