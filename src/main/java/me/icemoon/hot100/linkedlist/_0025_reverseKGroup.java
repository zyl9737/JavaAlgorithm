package me.icemoon.hot100.linkedlist;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/19
 * @description
 */
public class _0025_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = null;
        ListNode p0 = dummy;
        ListNode cur = head;
        while (n > k) {
            n -= k;
            for (int i = 0; i < k; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}
