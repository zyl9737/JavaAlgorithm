package me.icemoon.hot100.linkedlist;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/19
 * @description 两两交换链表中的节点
 */
public class _0024_swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = cur;
            pre.next = t;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
