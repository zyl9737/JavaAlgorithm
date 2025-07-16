package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/15
 * @description 155. 最小栈
 */
public class _0155_minstack {
    class MinStack {
        public final Deque<int[]> st = new ArrayDeque<>();

        public MinStack() {
            st.push(new int[]{0, Integer.MAX_VALUE}); // 初始化栈，存储一个哨兵元素
        }

        public void push(int val) {
            st.push(new int[]{val, Math.min(val, getMin())});
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek()[0];
        }

        public int getMin() {
            return st.peek()[1];
        }
    }
}
