package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/6/3
 * @description
 */
public class _0010_FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            // 如果p1到达了pHead1的末尾，则转到pHead2的开头
            p1 = (p1 == null) ? pHead2 : p1.next;
            // 如果p2到达了pHead2的末尾，则转到pHead1的开头
            p2 = (p2 == null) ? pHead1 : p2.next;
        }
        return p1;
    }
}
