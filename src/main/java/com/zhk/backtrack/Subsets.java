package com.zhk.backtrack;

import java.util.ArrayList;
import java.util.List;

//leetcode 78 子集
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        recur(0,nums,res,sub);
        return  res;

    }

    private void recur(int num,int[] nums, List<List<Integer>> res,List<Integer> sub) {
        //terminitor
        if (num == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }
        //logic process
        //不添加当前的元素
        recur(num + 1, nums, res, sub);
        //添加当前元素
        sub.add(nums[num]);
        recur(num + 1, nums, res,sub );
        //reverse
        sub.remove(sub.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        Subsets ss = new Subsets();
        List<List<Integer>> res = new ArrayList<>();
        res = ss.subsets(nums);
        System.out.println(res);
    }
}
