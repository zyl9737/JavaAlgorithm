package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Yulong
 * @create 2025/5/30
 * @description
 */
public class _0005_mergeKLists {
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(), (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll(); // 弹出最小节点
            cur.next = minNode; // 连接到结果链表
            cur = cur.next;
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}
