package com.xiekun.algs;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 初始化对角线都为 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int l=2; l<=n; l++){
            for (int i=0; i<=n-l; i++){
                int j = l + i - 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq().longestPalindromeSubseq("bbbab"));
    }
}
