package com.xiekun.algs;

import java.util.Arrays;
import java.util.Comparator;

public class Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - getBiggestOverlapIntervals(intervals);
    }

    public int getBiggestOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        int count = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        // 最小的结束端
        int s_end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if(intervals[i][0] >= s_end){
                count ++;
                s_end = intervals[i][1];
            }
        }
        return count;
    }
}
