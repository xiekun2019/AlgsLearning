package com.xiekun.algs;

public class Palindrome {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String getPalindrome(String s, int l, int r) {
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return s.substring(l+1, r);
    }

    /**
     * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
     * 请你返回让 s 成为回文串的 最少操作次数 。
     * 「回文串」是正读和反读都相同的字符串。
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(new Palindrome().longestPalindrome(s));
    }
}
