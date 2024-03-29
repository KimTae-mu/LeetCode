package com.alva.Leetcode.back;

import org.junit.Test;

/**
 * <一句话描述>,
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * <p>
 * <详细介绍>,
 * <p>
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }

        str = str.trim();

        if (str.isEmpty() || str.length() == 0) {
            return 0;
        }

        int len = str.length(), index = 0, ans = 0, sign = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }

        for (; index < len; index++) {
            int temp = str.charAt(index) - '0';
            if (temp < 0 || temp > 9) {
                break;
            }
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < temp)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                ans = ans * 10 + temp;
            }
        }
        return sign * ans;
    }

    @Test
    public void test(){
        String s = " ";
        System.out.println(myAtoi(s));
    }

    @Test
    public void testInteger(){
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
