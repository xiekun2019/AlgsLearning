package com.xiekun.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * 凑零钱问题
 *      给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，
 *      再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 */
public class CoinChange {
    static int [] coins = {1, 2, 5};
    static Map mem = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        System.out.println(dp2(12));
    }

    // 暴力递归
    static int dp(int amount) {

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            if (amount - coin < 0)
                continue;
            res = Math.min(res, 1 + dp(amount - coin));
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    // 带备忘录的递归
    static int dp2(int amount){

        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        if(mem.get(amount) != null) {
            return (Integer) mem.get(amount);
        }

        int res = Integer.MAX_VALUE;
        for (int coin: coins) {
            if(amount - coin < 0)
                continue;
            res = Math.min(res, 1 + dp(amount - coin));
        }

        res = res != Integer.MAX_VALUE ? res : -1;
        mem.put(amount, res);
        return res;
    }
}
