package com.alva.LeetCode.back;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class LongestPalindrome {

    public int solution(String s) {

        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();

        return ans < s.length() ? ans + 1 : ans;
    }
}
