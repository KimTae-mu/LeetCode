package com.alva.LeetCode;

import org.junit.Test;

/**
 * <一句话描述>,
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * <详细介绍>,
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 数字大小溢出判断是重点
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test() {
        int x = -123;
        System.out.println(reverse(x));
    }
}
