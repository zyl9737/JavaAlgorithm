package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description
 */
public class _0084_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int ans = 0;
        st.push(-1); // 哨兵，防止栈空
        for (int right = 0; right <= n; right++) {
            int h = right < n ? heights[right] : 0; // 右边界高度
            while (st.size() > 1 && h <= heights[st.peek()]) {
                int i = st.pop(); // 弹出栈顶元素
                int left = st.peek(); // 栈顶元素是左边界
                ans = Math.max(ans, heights[i] * (right - left - 1));
            }
            st.push(right); // 将当前右边界入栈
        }
        return ans;
    }
}
