package com.xiekun.algs;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int result = fib(46);
        long endTime = System.currentTimeMillis();
        System.out.println("暴力递归 fib(46) = " + result + " cost time: " + (endTime - startTime) + "毫秒");


        long startTime2 = System.currentTimeMillis();
        int result2 = fib2(46);
        long endTime2 = System.currentTimeMillis();
        System.out.println("带备忘录的递归解法 fib(46) = " + result2 + " cost time: " + (endTime2 - startTime2) + "毫秒");

        long startTime3 = System.currentTimeMillis();
        int result3 = fib3(46);
        long endTime3 = System.currentTimeMillis();
        System.out.println("dp 数组的迭代解法 fib(46) = " + result2 + " cost time: " + (endTime3 - startTime3) + "毫秒");


    }

    // 1. 暴力递归
    public static int fib(int N) {
        if (N ==1 || N == 2) return 1;
        return fib(N - 1) + fib(N -2);
    }

    // 2. 带备忘录的递归解法
    public static int fib2(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[100];
        for (int i = 0; i < 100; i++) {
            memo[i] = 0;
        }
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    public static int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        if (memo[n] != 0)
            return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    // 3. dp 数组的迭代解法
    public static int fib3(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2) return 1;
        int[] dp = new int[100];
        for (int i = 0; i < 100; i++) {
            dp[i] = 0;
        }
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N];
    }


}
