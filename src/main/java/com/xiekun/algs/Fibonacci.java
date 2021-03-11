package com.xiekun.algs;

public class Fibonacci {
    public static void main(String[] args) {
        int result = fib(20);
        System.out.println("fib(2) = " + result);
    }

    // 1. 暴力递归
    public static int fib(int N) {
        if (N ==1 || N == 2) return 1;
        return fib(N - 1) + fib(N -2);
    }
}
