package com.jasons.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CoinChange {
    /**
     * Get mini num of coins
     * 
     * @param coinValues
     *            coins
     * @param totalMoney
     *            total money
     * @return
     */
    public int coinNum(int[] coinValues, int totalMoney) {
        List<Integer> coins = new ArrayList<Integer>();
        coins.add(0);
        for (int i = 1; i <= totalMoney; i++) {
            int coin = nearestCoin(i, coinValues);
            int coinNum = coins.get(i - coin) + 1;
            coins.add(coinNum);
        }
        return coins.get(totalMoney);
    }

    /**
     * Get the coin nearest to specified value.
     */
    private int nearestCoin(int money, int[] coinValues) {
        int res = 0;
        int nearest = Integer.MAX_VALUE;
        for (int coinValue : coinValues) {
            if (coinValue <= money) {
                int distance = money - coinValue;
                if (distance < nearest) {
                    nearest = distance;
                    res = coinValue;
                }
            }
        }
        return res;
    }

    @Test
    public void test() throws Exception {
        int res = coinNum(new int[] { 1, 2, 3, 5, 11 }, 81);
        System.out.println(res);
    }
}