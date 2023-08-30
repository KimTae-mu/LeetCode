package com.alva.Leetcode.back;

import org.junit.Test;

/**
 * <一句话描述>,
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <详细介绍>,
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        int index = 1;
        while (index < strs.length) {
            while (strs[index].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
            index++;
        }
        return result;
    }

    @Test
    public void test() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
