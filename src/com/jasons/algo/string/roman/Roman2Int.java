package com.jasons.algo.string.roman;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * <pre>
        Input is guaranteed to be within the range from 1 to 3999.
        
        Read more details about roman numerals at Roman Numeric System
        
        Example :
        
        Input : "XIV"
        Return : 14
        Input : "XX"
        Output : 20
        
        
        
        Symbol  Value
        I   1
        V   5
        X   10
        L   50
        C   100
        D   500
        M   1,000
 * 
 * </pre>
 * 
 * @author shishu
 */
public class Roman2Int {
    private static HashMap<Character, Integer> charMap = new HashMap<>();

    static {
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
    }

    public int romanToInt(String a) {
        if (a == null || a.trim().isEmpty()) {
            return 0;
        }
        char[] cs = a.toCharArray();
        int sum = 0;
        for (int i = 0; i < cs.length; i++) {
            int ci = charMap.get(cs[i]);
            if (i < cs.length - 1) {
                int ci_next = charMap.get(cs[i + 1]);
                if (ci < ci_next) {
                    sum -= ci;
                }
                else {
                    sum += ci;
                }
            }
            else {
                sum += ci;
            }
        }
        return sum;
    }

    @Test
    public void test() throws Exception {
        Roman2Int test = new Roman2Int();
        System.out.println(test.romanToInt("XIV")); // 14
        System.out.println(test.romanToInt("XX")); // 20
        System.out.println(test.romanToInt("MDCCCIV")); // 1804
        
    }
}

/**
 * Access Hint
 * 
 * <pre>
 * The key is to notice that in a valid Roman numeral representation
 * the letter with the most value always occurs at the start of the string.
 * 
 * Whenever a letter with lesser value precedes a letter of higher value, it
 * means its value has to be added as negative of that letter’s value.
 * 
 * In all other cases, the values get added.
 * </pre>
 */
