package com.xiekun.algs;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Combine {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0)
            return null;
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> track) {
        if(track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            // track.add(start);
            backtrack(n, k, i+1, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
