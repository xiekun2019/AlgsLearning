package com.xiekun.algs;

import java.util.Arrays;
import java.util.Scanner;

public class EatGrape {
    public static long leastEat(long a, long b, long c) {
        long[] grape_nums = {a, b, c};
        Arrays.sort(grape_nums);

        if (grape_nums[2] > 2 * (grape_nums[0] + grape_nums[1])) {
            return (grape_nums[2] + 1) /2;
        }

        return (a + b + c + 2) / 3;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sets = Integer.parseInt(s.nextLine());
        String [] next = new String[sets];
        for (int i = 0; i < sets; i++) {
            next[i] = s.nextLine();
        }

        for (int i = 0; i < sets; i++) {
            String[] s1 = next[i].split(" ");
            System.out.println(EatGrape.leastEat(Long.parseLong(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2])));
        }
    }
}
