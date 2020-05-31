package com.zhk.Array;

public class MoveZeroes {
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

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                if ( i!= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }
}
