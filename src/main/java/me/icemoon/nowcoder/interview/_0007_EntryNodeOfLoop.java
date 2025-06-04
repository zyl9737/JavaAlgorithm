package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/5/31
 * @description
 */
public class _0007_EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        // 使用快慢指针查找环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 找到环的入口
                ListNode entry = pHead;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry; // 返回环的入口节点
            }
        }
        return null; // 没有环
    }
}
