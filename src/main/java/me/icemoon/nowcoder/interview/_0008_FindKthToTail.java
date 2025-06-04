package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/6/3
 * @description
 */
public class _0008_FindKthToTail {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 快指针先走k步
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // 如果k大于链表长度，返回null
            }
            fast = fast.next;
        }
        // 快慢指针同时移动，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时慢指针指向的就是倒数第k个节点
        return slow;
    }
}
