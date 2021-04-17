package com.xiekun.algs;


public class Koko {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMax(piles);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(canFinish(piles, h, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int mid) {
        for (int pile : piles) {
            if (pile < mid) {
                h --;
            } else {
                h -= (pile % mid == 0 ? pile/mid : pile/mid + 1);
            }
        }
        return h >= 0;
    }

    private int getMax(int[] piles) {
        int res = piles[0];
        for (int i = 1; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }
        return res;
    }
}
