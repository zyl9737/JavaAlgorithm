package me.icemoon.hot100.linkedlist;

import me.icemoon.tools.ListNode;

import java.util.PriorityQueue;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description
 */
public class __0023_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
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
