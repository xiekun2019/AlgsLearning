package com.xiekun.algs;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        // 定义 dp 数组
        int dp_0 = nums[0];
        int dp_1 = 0;
        int res = dp_0;

        for (int i=1; i<nums.length; i++){
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;

            res = Math.max(res, dp_1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }
}
