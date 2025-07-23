package me.icemoon.hot100.trick;

/**
 * @author Yulong
 * @create 2025/7/22
 * @description
 */
public class _0136_singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // 使用异或操作
        }
        return result; // 返回唯一的数字
    }
}
