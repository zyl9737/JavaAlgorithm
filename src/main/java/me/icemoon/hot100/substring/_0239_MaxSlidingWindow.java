package me.icemoon.hot100.substring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yulong
 * @create 2025/4/13
 * @description 滑动窗口最大值，单调队列做法，
 * 时间复杂度：O(n)
 * 空间复杂度：O(min(k, U))
 */
public class _0239_MaxSlidingWindow {
    // ArrayDeque做法
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // 双端队列
        for (int i = 0; i < n; i++) {
            // 1. 入
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast(); // 维护 q 的单调性
            }
            q.addLast(i); // 入队
            // 2. 出
            if (i - q.getFirst() >= k) { // 队首已经离开窗口了
                q.removeFirst();
            }
            // 3. 记录答案
            if (i >= k - 1) {
                // 由于队首到队尾单调递减，所以窗口最大值就是队首
                ans[i - k + 1] = nums[q.getFirst()];
            }
        }
        return ans;
    }

    // LinkedList做法
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
            if (i >= k) {
                if (stack.peekLast() <= (i - k)) {
                    stack.pollLast();
                }
            }
            if (i >= k - 1) {
                res[i - k + 1] = nums[stack.peekLast()];
            }

        }
        return res;
    }
}
