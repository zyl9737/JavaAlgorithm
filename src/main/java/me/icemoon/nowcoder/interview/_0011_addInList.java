package me.icemoon.nowcoder.interview;

import me.icemoon.tools.ListNode;

/**
 * @author Yulong
 * @create 2025/6/3
 * @description 两数相加Ⅱ
 */
public class _0011_addInList {
    public ListNode addInList (ListNode l1, ListNode l2) {
        l1 = reversedList(l1);
        l2 = reversedList(l2);
        ListNode l3 = addTwo(l1, l2);
        return reversedList(l3);
    }
//    private ListNode reversedList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode newHead = reversedList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
//
//    private ListNode addTwo(ListNode l1, ListNode l2, int carry) {
//        if (l1 == null && l2 == null) {
//            return carry != 0 ? new ListNode(carry) : null;
//        }
//        if (l1 == null) {
//            l1 = l2;
//            l2 = null;
//        }
//        carry += l1.val + (l2 != null ? l2.val : 0);
//        l1.val = carry % 10;
//        l1.next = addTwo(l1.next, l2 != null ? l2.next : null, carry / 10);
//        return l1;
//    }

    private ListNode reversedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next; // 保存下一个节点
            current.next = prev; // 反转当前节点的指针
            prev = current; // 移动 prev 到当前节点
            current = nextTemp; // 移动到下一个节点
        }
        return prev; // 返回新的头节点
    }

    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) carry += l1.val; // 节点值和进位加在一起
            if (l2 != null) carry += l2.val; // 节点值和进位加在一起
            cur = cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            carry /= 10; // 新的进位
            if (l1 != null) l1 = l1.next; // 下一个节点
            if (l2 != null) l2 = l2.next; // 下一个节点
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }

    public static void main(String[] args) {
        _0011_addInList solution = new _0011_addInList();
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solution.addInList(l1, l2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
