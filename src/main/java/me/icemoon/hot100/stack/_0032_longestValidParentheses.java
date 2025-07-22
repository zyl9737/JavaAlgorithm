package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Yulong
 * @create 2025/7/21
 * @description
 */
public class _0032_longestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || s.charAt(i) == '(' || s.charAt(st.peek()) == ')') {
                st.push(i);
            } else {
                st.pop();
                ans = Math.max(ans, i - (st.isEmpty() ? -1 : st.peek()));
            }
        }
        return ans;
    }
}
