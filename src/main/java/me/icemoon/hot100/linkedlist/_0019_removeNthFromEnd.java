package me.icemoon.hot100.linkedlist;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/19
 * @description
 */
public class _0019_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;
        while (n-- > 0) {
            right = right.next;
        }
        for (; right.next != null; right = right.next) {
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
