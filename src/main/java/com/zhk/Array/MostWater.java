package com.zhk.Array;

//leetcode 11
public class MostWater {
    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return 0;
        }
        for (int i = 0; i < height.length; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int area = Math.min(height[i], height[j]) * (j - i);
                res = Math.max(res, area);
            }
        }
        return res;
    }

    public int maxAreaTwoPoint(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
    public int maxArea2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0,j = height.length - 1;i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;// +1 因为上一步i++或者j--了
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    // leetcode 283
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (; j < nums.length; ++j) {
            nums[j] = 0;
        }
    }
}
