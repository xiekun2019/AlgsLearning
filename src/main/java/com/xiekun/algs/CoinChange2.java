package com.xiekun.algs;


public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp 数组的定义
        // dp[i][j]: 表示用前 i 个硬币凑成 j 元，有 dp[i][j] 种方法。
        int dp[][] = new int[n + 1][amount + 1];

        // base case
        // dp[0][...] = 0，dp[...][0] = 1
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        // 状态转移
        // 当不把第 i 种金额的硬币加入计算总金额 j 时，dp[i][j] = dp[i-1][j]，直接继承前 i-1 种硬币的方法次数；
        // 当把第 i 种金额的硬币加入计算总金额 j 时，dp[i][j] = dp[i][j-coins[i]]；
        // 将二者相加即可。
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if(j - coins[i-1] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }
}
