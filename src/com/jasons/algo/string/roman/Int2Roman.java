package com.jasons.algo.string.roman;

import java.util.LinkedHashMap;
import java.util.Set;

import org.junit.Test;

/**
 * Please note: <br>
 * 
 * Another question which belongs to the category of questions which are
 * intentionally stated vaguely. Expectation is that you will ask for correct
 * clarification or you will state your assumptions before you start coding.
 * 
 * <pre>
 *  Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

            Input is guaranteed to be within the range from 1 to 3999.
            
            Example :
            
            Input : 5
            Return : "V"
            
            Input : 14
            Return : "XIV"
 * </pre>
 * 
 * Note : This question has a lot of scope of clarification from the
 * interviewer. Please take a moment to think of all the needed clarifications
 * and see the expected response using “See Expected Output”
 * 
 * For the purpose of this question,
 * https://projecteuler.net/about=roman_numerals has very detailed explanations.
 * 
 * @author shishu
 *
 */
public class Int2Roman {

    private static LinkedHashMap<Integer, String> intRomanMap = new LinkedHashMap<>();

    /**
     * <pre>
     * NOTE:<br> 
     * Only list 1000, 500, 100, ... 5, 1is not enough. <br>
     * Also need: 900, 400,  90, ... 4
     * 
     * Cause: For 14,
     * 
     *   IF without 4, it will be "XIIII", 
     *   IF with    4, it will be "XIV"
     * 
     * </pre>
     * 
     */
    static {
        intRomanMap.put(1000, "M");
        intRomanMap.put(900, "CM");
        intRomanMap.put(500, "D");
        intRomanMap.put(400, "CD");
        intRomanMap.put(100, "C");
        intRomanMap.put(90, "XC");
        intRomanMap.put(50, "L");
        intRomanMap.put(40, "XL");
        intRomanMap.put(10, "X");
        intRomanMap.put(9, "IX");
        intRomanMap.put(5, "V");
        intRomanMap.put(4, "IV");
        intRomanMap.put(1, "I");
    }

    public String intToRoman(int num) {
        Set<Integer> keys = intRomanMap.keySet();

        StringBuffer buf = new StringBuffer();
        for (int k : keys) {
            int divide = num / k;
            for (int i = 0; i < divide; i++) {
                buf.append(intRomanMap.get(k));
            }
            int remain = num % k;
            if (remain == 0) {
                return buf.toString();
            }
            num = remain;
        }
        return buf.toString();
    }

    // ==================== Solution 2 =======================
    public String intToRoman2(int n) {
        int[] A = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] B = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
                       "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            while (n >= A[i]) {
                sb.append(B[i]);
                n -= A[i];
            }
        }
        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        Int2Roman test = new Int2Roman();
        System.out.println(test.intToRoman(4));
        System.out.println(test.intToRoman(14));
    }
}

/**
 * <pre>
 * It is very much like learning our own number system.

    All you need to know is how to write 0-9, 10, 20, 30, 40, .. 90, 100, 200, 300,… 900, 1000, 2000, 3000.
    
    You can derive rest of the numbers using the above.
 * </pre>
 */
