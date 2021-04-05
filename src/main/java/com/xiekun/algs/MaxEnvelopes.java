package com.xiekun.algs;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        // 对信封进行排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        int[] heights = new int[envelopes.length];
        for (int i=0; i<heights.length; i++){
            heights[i] = envelopes[i][1];
        }
        return LISLength(heights);
    }

    // 求最长递增子序列
    int LISLength(int[] sq) {
        int m = sq.length;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int i=0; i<m; i++){
            for(int j=0; j<i; j++){
                if(sq[j]<sq[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i=0; i<m; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new MaxEnvelopes().maxEnvelopes(envelopes));
    }
}
