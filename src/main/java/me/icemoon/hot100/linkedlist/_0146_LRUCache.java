package me.icemoon.hot100.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description
 */
public class _0146_LRUCache {
    // LRUCache 的实现可以使用双向链表和哈希表来维护缓存的顺序和快速访问
    // 这里是一个简单的示例，实际实现可能需要更多细节处理

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public _0146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            remove(node);
            addToHead(node);

        } else {
            if (cache.size() >= capacity) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, val);
            addToHead(node);
            cache.put(key, node);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        _0146_LRUCache lruCache = new _0146_LRUCache(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1)); // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2)); // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {3=3, 4=4}
        System.out.println(lruCache.get(1)); // 返回 -1 (未找到)
        System.out.println(lruCache.get(3)); // 返回 3
        System.out.println(lruCache.get(4)); // 返回 4
    }
}
