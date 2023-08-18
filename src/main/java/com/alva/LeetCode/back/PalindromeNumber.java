package com.alva.LeetCode.back;

import org.junit.Test;

/**
 * <一句话描述>,
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * <详细介绍>,
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // 最后一位为0且不为0的数字一定不是回文
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int index = 0;
        // 一次性将数字倒置,最后判断与初始是否相同
        while (x > index) {
            index = index * 10 + x % 10;
            x /= 10;
        }
        return index == x || x == index / 10;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-323));
    }
}
