package me.icemoon.hot100.greedy;

/**
 * @author Yulong
 * @create 2025/7/17
 * @description
 */
public class _0055_canJump {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
