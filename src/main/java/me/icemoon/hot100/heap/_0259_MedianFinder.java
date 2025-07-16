package me.icemoon.hot100.heap;

import java.util.PriorityQueue;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description
 */
public class _0259_MedianFinder {
    class MedianFinder {

        private PriorityQueue<Integer> maxHeap; // 存储较小的一半
        private PriorityQueue<Integer> minHeap; // 存储较大的一半

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
            minHeap = new PriorityQueue<>(); // 最小堆
        }

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            return minHeap.size() == maxHeap.size()
                ? (minHeap.peek() + maxHeap.peek()) / 2.0
                : maxHeap.peek();
        }
    }
}
