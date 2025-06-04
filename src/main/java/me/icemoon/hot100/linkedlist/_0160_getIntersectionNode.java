package me.icemoon.hot100.linkedlist;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/12
 * @description
 */
public class _0160_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }
}
