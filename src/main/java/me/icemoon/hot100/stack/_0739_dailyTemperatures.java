package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description 739. 每日温度
 */
public class _0739_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }
        return res;
    }
}
