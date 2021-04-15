package com.xiekun.algs;

import java.util.HashMap;
import java.util.Map;

public class HouseRob {

    public int rob2(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(rob_range(nums, 0, n-2), rob_range(nums, 1, n-1));
    }

    public int rob_range(int[] nums, int start, int end) {
        int dp_i1 = 0, dp_i2 = 0, dp_i = 0;
        for (int i = end; i >= start ; i--) {
            dp_i = Math.max(dp_i1, dp_i2 + nums[i]);
            dp_i2 = dp_i1;
            dp_i1 = dp_i;
        }
        return dp_i;
    }

    Map<TreeNode, Integer> memo = new HashMap();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(memo.containsKey(root))
            return memo.get(root);
        int not_rob = rob(root.left) + rob(root.right);
        int rob = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int res = Math.max(rob, not_rob);
        memo.put(root, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
