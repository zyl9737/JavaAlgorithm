package me.icemoon.hot100.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description 347. 前 K 个高频元素
 */
public class _0347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for (var e : cnt.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(Map.Entry::getKey)
                .toArray();
    }
    public static void main(String[] args) {
        _0347_topKFrequent solution = new _0347_topKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // 输出: 1 2
    }
}
