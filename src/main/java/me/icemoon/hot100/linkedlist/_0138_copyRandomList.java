package me.icemoon.hot100.linkedlist;

/**
 * @author Yulong
 * @create 2025/6/4
 * @description
 */


public class _0138_copyRandomList {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val, Node next) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next) {
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = copy.next.next;
        }
        cur.next = null;
        return newHead;
    }
}
