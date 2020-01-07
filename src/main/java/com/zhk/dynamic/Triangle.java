package com.zhk.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

//leetcode 120
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        return helper(triangle, 0, 0, res);
    }

    private int helper(List<List<Integer>> triangle, int i, int j, int min) {
        int res = 0;
        if (triangle.size() == i) {
            return res < min ? res : min;
        }
        return min(triangle.get(i).get(j) + helper(triangle, i + 1, j, min),
                triangle.get(i).get(j) + helper(triangle, i + 1, j + 1, min));
    }

    public int minimumTotaldp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int level = triangle.size();
        int[][] min = new int[level][triangle.get(level-1).size()];
        for (int j = 0; j < triangle.get(level-1).size(); j++){
            min[level-1][j] = triangle.get(level-1).get(j);
        }
        for (int i = level - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size();j++)  {
                min[i][j] = min(min[i+1][j],min[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return min[0][0];
    }

    public static int minimumTotalwithMem(List<List<Integer>> triangle) {
        int level = triangle.size();
        List<List<Integer>> memory = new ArrayList<>();
        memory.add(new ArrayList<>());
        return helper1(triangle, 0, 0, level, memory);
    }

    // 参数i表示当前层，level表示共有多少层
    public static int helper1(List<List<Integer>> triangle, int i, int j, int level, List<List<Integer>> memory) {
        if (i >= level || j >= triangle.get(i).size())
            return 0;
        // 到了最后一层，就将结果全部放入
        if (i == level - 1 && memory.get(i).isEmpty()) {
            for (int k = 0; k < triangle.get(i).size(); k++)
                memory.get(i).add(triangle.get(i).get(k));
        }

        if (!memory.get(i).isEmpty() && j < memory.get(i).size() && memory.get(i).get(j) != null)
            return memory.get(i).get(j);

        if (memory.size() < level) // 防止添加回溯的过程又添加
            memory.add(new ArrayList<>());

        int left = helper1(triangle, i + 1, j, level, memory);
        int right = helper1(triangle, i + 1, j + 1, level, memory);
        memory.get(i).add(Math.min(left, right) + triangle.get(i).get(j));

        return memory.get(i).get(j);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        //int res = Triangle.minimumTotalwithMem(list);
        int res =  new Triangle().minimumTotaldp(list);
        System.out.println("res 1111111111===>" + res);
    }
}
