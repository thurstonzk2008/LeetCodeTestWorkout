package com.zhk.backtrack;

//leetcode 50
public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -1 * N;
        }

        return recur(x,N);

    }

    private double recur(double x, long n) {
        if (n == 0) {
            return  1.0;
        }
        return n % 2 == 0 ? recur(x*x,n / 2) : x * recur(x*x,n / 2);
    }

    private double recur2(double x, long n) {
        if (n == 0) {
            return  1.0;
        }
        double res = recur (x,n/2);
        return n % 2 == 0 ? res * res : x * res * res;
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println("res====>" + pow.myPow(2.0,-4));
    }
}
