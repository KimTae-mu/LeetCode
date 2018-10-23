package com.alva.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话描述>,
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <详细介绍>,
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        // 字符串为空或生成一行时,直接返回s
        if (s == null || numRows <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int len = chars.length;

        // 初始化numRows个StringBuffer对象,(建议使用StringBuilder)
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            // 将字符依次放入StringBuffer数组中,条件为idx < numRows
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(chars[i++]);
            }
            // 放完一轮(numRows)后,倒着数组放入字符
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(chars[i++]);
            }
        }
        // 将多个StringBuffer数组合并为一个
        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }

    /**
     * 使用ArrayList
     *
     * 生成一个numRows和s.length()中较小值的List
     * @param s
     * @param numRows
     * @return
     */
    public String convertUseList(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean dirt = false;

        // 将字符放入list的StringBuffer中
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 更改方向条件,curRow=0或=numRows - 1
            if (curRow == 0 || curRow == numRows - 1) {
                dirt = !dirt;
            }
            curRow += dirt ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }

    /**
     * 对题目理解有误,题目仅要求生成一行,对题目的理解造成了误解,复杂化
     */
    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
