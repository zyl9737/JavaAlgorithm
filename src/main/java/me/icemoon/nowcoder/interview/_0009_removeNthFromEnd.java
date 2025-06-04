package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/6/3
 * @description
 */
public class _0009_removeNthFromEnd {
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return head; // 如果n大于链表长度，直接返回原链表
            }
        }
        // 快慢指针一起走，直到快指针到达链表末尾
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除慢指针的下一个节点
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        // 返回新的头节点
        return dummy.next;
    }
}
