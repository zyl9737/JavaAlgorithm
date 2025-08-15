package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/25
 * @description
 */
public class _0238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] s1 = new int[n];
        int[] s2 = new int[n];
        s1[0] = nums[0];
        s2[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            s1[i] = s1[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            s2[i] = s2[i + 1] * nums[i];
        }
        int[] res = new int[n];
        res[0] = s2[1];
        res[n - 1] = s1[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = s1[i - 1] * s2[i + 1];
        }
        return res;
    }
}
