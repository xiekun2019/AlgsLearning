package com.xiekun.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) {
            List<Integer> in = new ArrayList<>();
            List<List<Integer>> out = new ArrayList<>();
            out.add(in);
            return out;
        }
        int last = nums[nums.length-1];
        int[] nums_no_last = Arrays.copyOfRange(nums, 0, nums.length - 1);
        List<List<Integer>> res = subsets(nums_no_last);

        int size = res.size();
        for (int i = 0; i < size; i++) {
            res.add(new ArrayList<>(res.get(i)));
            res.get(i).add(last);
        }

        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    // 回溯解法
    public List<List<Integer>> subsets2(int[] nums) {
        // 记录走过的路径
        List<Integer> track = new ArrayList<>();
        backTrack(nums, 0, track);
        return res;
    }

    public void backTrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrack(nums, i+1, track);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubSet().subsets2(new int[]{1, 2, 3}));
    }
}
