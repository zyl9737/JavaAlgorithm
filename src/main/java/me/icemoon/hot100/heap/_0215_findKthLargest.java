package me.icemoon.hot100.heap;

import java.util.PriorityQueue;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description
 */
public class _0215_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}
