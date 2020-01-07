package com.zhk.dynamic;
// leecode 70
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        int res = new ClimbStairs().climbStairs(11);
        System.out.println("res====>" + res);
    }
}
