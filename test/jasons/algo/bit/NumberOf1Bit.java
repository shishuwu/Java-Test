package jasons.algo.bit;

import org.junit.Test;

public class NumberOf1Bit {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    @Test
    public void test() throws Exception {
        System.out.println(hammingWeight(11222));
    }
}
