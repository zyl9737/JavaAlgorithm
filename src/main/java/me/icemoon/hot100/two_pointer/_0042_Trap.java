package me.icemoon.hot100.two_pointer;

import java.util.Deque;
import java.util.LinkedList;

public class _0042_Trap {

    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stk = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while(!stk.isEmpty() && height[stk.peek()] < height[i]) {
                int bottomH = height[stk.pop()];
                int left = stk.peek();
                int dH = Math.min(height[i], height[left]) - bottomH;
                int dW = i - left;
                ans += dW * dH;
            }
            stk.push(i);
        }
        return ans;
    }

}
