package com.xiekun.algs;

public class Stock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }

    public int maxProfit_k_1(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }
        return dp_i10;
    }

    public int maxProfit_k_inf(int[] prices) {
        int dp_ik0 = 0, dp_ik1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_ik0;
            dp_ik0 = Math.max(dp_ik0, dp_ik1 + prices[i]);
            dp_ik1 = Math.max(dp_ik1, temp - prices[i]);
        }

        return dp_ik0;
    }

    public int maxProfit_with_cool(int[] prices) {
        int dp_ik0 = 0, dp_ik1 = Integer.MIN_VALUE;
        int dp_i2k0 = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_ik0;
            dp_ik0 = Math.max(dp_ik0, dp_ik1 + prices[i]);
            dp_ik1 = Math.max(dp_ik1, dp_i2k0 - prices[i]);
            dp_i2k0 = temp;
        }

        return dp_ik0;
    }

    public int maxProfit_with_fee(int[] prices, int fee) {
        int dp_ik0 = 0, dp_ik1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_ik0;
            dp_ik0 = Math.max(dp_ik0, dp_ik1 + prices[i]);
            dp_ik1 = Math.max(dp_ik1, temp - prices[i] - fee);
        }

        return dp_ik0;
    }

    public int maxProfit_k_2(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];
    }

    public int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if(max_k > n/2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Stock().maxProfit(prices));
    }
}
