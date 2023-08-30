package com.alva.Leetcode.back;

import org.junit.Test;

/**
 * <一句话描述>,
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * *
 * * Note: You may not slant the container and n is at least 2.
 * <详细介绍>,
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                int temp = min * (j - i);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public int maxArea_Solution(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


    @Test
    public void test() {
        int[] input = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea_Solution(input));
    }

}
