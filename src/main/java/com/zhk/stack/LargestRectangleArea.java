package com.zhk.stack;

import java.util.Stack;

/**
 * @author zhuhk
 * @create 2020-03-07 8:21 上午
 * @Version 1.0
 **/
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, heights[k]);
                }
//                int area = calulateArea(heights[i],heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;

    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;

    }

    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> minStack = new Stack<>();
        int maxArea = 0;
        minStack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (minStack.peek() != -1 && heights[minStack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[minStack.pop()] * (i - minStack.peek() - 1));
            }
            minStack.push(i);
        }
        while (minStack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[minStack.pop()] * (heights.length - minStack.peek() - 1));
        }
        return maxArea;
    }

    private int calulateArea(int height, int height1) {
        int area = (Math.max(height, height1) - Math.min(height, height1)) * (height1 - height);
        return area;
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 5, 6, 2, 3};
        int res = new LargestRectangleArea().largestRectangleArea3(data);
        System.out.println("res===>" + res);
    }
}
