package com.alva.LeetCode.back;

import org.junit.Test;

/**
 * <一句话描述>,
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * <详细介绍>,
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class RomantoInteger {

    public int romanToInt(String s) {

        int sum = 0;
        int[] num = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (Roman temp : Roman.values()) {
                if (s.charAt(i) == temp.getValue().charAt(0)) {
                    num[i] = temp.getKey();
                }
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (num[i] < num[i + 1]) {
                sum -= num[i];
            }else {
                sum += num[i];
            }
        }
        return sum + num[s.length() - 1];
    }

    enum Roman {
        M(1000, "M"),
//        CM(900, "CM"),
        D(500, "D"),
//        CD(400, "CD"),
        C(100, "C"),
//        XC(90, "XC"),
        L(50, "L"),
//        XL(40, "XL"),
        X(10, "X"),
//        IX(9, "IX"),
        V(5, "V"),
//        IV(4, "IV"),
        I(1, "I");

        private final Integer key;

        private final String value;

        Roman(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public Integer getKey() {
            return key;
        }
    }

    @Test
    public void test() {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
