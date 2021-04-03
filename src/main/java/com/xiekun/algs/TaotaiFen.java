package com.xiekun.algs;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TaotaiFen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[] scores = new int[num];

        for (int i = 0; i < num; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println(lowestScore(num, x, y, scores));
    }

    public static int lowestScore(int num, int x, int y, int[] scores) {
        ArrayList<Integer> scoresArrays = new ArrayList<Integer>();
        for (int i = 0; i < scores.length; i++) {
            scoresArrays.add(scores[i]);
        }
        scoresArrays.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int left = 1, right = num;
        while (right > left) {
            int mid = (left + right) / 2;
            if (mid <= y && mid >= x && (num-mid) <= y && (num-mid) >= x) {
                right = mid;
                // return scoresArrays.get(mid - 1);
            } else if(mid > y) {
                right = mid;
            } else if(mid < x ){
                left = mid + 1;
            }
        }

        return scoresArrays.get(left-1);
    }
}
