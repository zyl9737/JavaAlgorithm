package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description
 */
public class _0055_canJump {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true; // 如果能覆盖到最后一个位置，返回true
            }
        }
        return false;
    }
}
