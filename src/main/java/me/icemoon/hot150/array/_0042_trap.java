package me.icemoon.hot150.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/28
 * @description
 */
public class _0042_trap {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stk = new ArrayDeque<>(); // 单调栈，从栈顶到栈底元素高度递增
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && height[i] > height[stk.peek()]) {
                int top = stk.pop();
                if (stk.isEmpty()) break;
                int left = stk.peek();
                int h = Math.min(height[left], height[i]) - height[top];
                res += (i - left - 1) * h;
            }
            stk.push(i);
        }
        return res;
    }
}
