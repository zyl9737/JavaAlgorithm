package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description
 */
public class _0045_jump {
    public int jump(int[] nums) {
        int jumps = 0; // 跳跃次数
        int currentEnd = 0; // 当前跳跃的最远位置
        int farthest = 0; // 能跳到的最远位置

        for (int i = 0; i < nums.length - 1; i++) { // 不需要到达最后一个位置
            farthest = Math.max(farthest, i + nums[i]); // 更新能跳到的最远位置
            if (i == currentEnd) { // 到达当前跳跃的最远位置
                jumps++; // 增加跳跃次数
                currentEnd = farthest; // 更新当前跳跃的最远位置
            }
        }
        return jumps;
    }
}
