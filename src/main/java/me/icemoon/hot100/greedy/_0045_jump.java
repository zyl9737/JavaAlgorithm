package me.icemoon.hot100.greedy;

/**
 * @author Yulong
 * @create 2025/7/17
 * @description 45. 跳跃游戏 II
 */
public class _0045_jump {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int cover = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = cover;
            }
        }

        return jumps;
    }
}
