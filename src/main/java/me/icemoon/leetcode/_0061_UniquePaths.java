package me.icemoon.leetcode;

/**
 * @author Yulong
 * @create 2025/4/13
 * @description 组合数
 */
public class _0061_UniquePaths {
    public static int uniquePaths(int m, int n) {
        return (int) comb(m + n - 2, m - 1);
    }

    private static long comb(int n, int k) {
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n + 1 - i) / i;
        }
        return res;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(3, 7));
    }
}
