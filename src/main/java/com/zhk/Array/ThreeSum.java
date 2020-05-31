package com.zhk.Array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhuhk
 * @create 2020-02-12 8:33 上午
 * @Version 1.0
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; ) {

                if (nums[j] + nums[k] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (hm.containsKey(nums[j])) {
                    List list = hm.get(nums[j]);
                    list.add(nums[j]);
                    res.add(list);
                } else {
                    int target = -nums[i] - nums[j];
                    hm.put(target, Arrays.asList(nums[i], nums[j]));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            index.put(nums[i], i);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -nums[i] - nums[j];
                if (index.containsKey(target) && index.get(target) > j) {
                    r.add(Arrays.asList(nums[i], nums[j], target));
                    j = index.get(nums[j]);
                }
                i = index.get(nums[i]);
            }
        }
        return r;
    }

    public List<List<Integer>> threeSum4(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new ThreeSum().threeSum3(nums);
        System.out.println(res);
    }
}
