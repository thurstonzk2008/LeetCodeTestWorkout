package com.zhk.unionfind;

import java.util.Arrays;

// leetcode 547. 朋友圈
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        for (int i =0 ; i < parent.length; i++) {
            parent[i] = i;
        }
//        Arrays.fill(parent,-1);
        for (int i = 0; i < M.length; i++ ){
            for (int j = 0 ; j < M.length; j++) {
                if (M[i][j] == 1 && i != j ) {
                    union(i,j,parent);
                }
            }
        }
        int count = 0;
        for (int i =0; i < parent.length;i++) {
            if (parent[i] == i) {
                count ++;
            }
        }
        return  count;

    }

    private void union(int i, int j, int[] parent) {
        int p = find (i,parent);
        int q = find (j,parent);
        if (p==q){
            return;
        }
        parent[p] = q;
    }

    private int find(int p, int[] parent) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
