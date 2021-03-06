package com.xiekun.algs;

public class PokeBalloon {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(new PokeBalloon().maxCoins(nums));
    }
}
