package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/31
 * @description
 */
public class _0006_hasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
