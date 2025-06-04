package me.icemoon.handwriting;

/**
 * @author Yulong
 * @create 2025/4/25
 * @description
 */
public class SimpleQueue<T> {
    private final T[] data; // 存储队列元素的数组
    private int head; // 队首指针
    private int tail; // 队尾指针
    private int size; // 队列当前大小

    // 构造函数，初始化队列
    public SimpleQueue(int capacity) {
        this.data = (T[]) new Object[capacity]; // 初始化数组
        this.head = 0; // 队首指针初始化为0
        this.tail = 0; // 队尾指针初始化为0
        this.size = 0; // 初始化队列大小为0
    }

    // 入队操作
    public synchronized void enqueue(T item) {
        if (size == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        data[tail] = item; // 将元素插入到队尾
        tail = (tail + 1) % data.length; // 移动队尾指针，循环使用数组
        size++; // 增加队列大小
    }

    // 出队操作
    public synchronized T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = data[head]; // 获取队首元素
        data[head] = null; // 清除引用（可选）
        head = (head + 1) % data.length; // 移动队首指针，循环使用数组
        size--; // 减少队列大小
        return item;
    }

    // 查看队首元素但不移除
    public synchronized T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[head];
    }

    // 判断队列是否为空
    public synchronized boolean isEmpty() {
        return size == 0;
    }

    // 判断队列是否已满
    public synchronized boolean isFull() {
        return size == data.length;
    }

    // 获取队列当前大小
    public synchronized int size() {
        return size;
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> queue = new SimpleQueue<>(5);

        // 测试入队操作
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // 测试队列满的情况
        System.out.println("Queue is full: " + queue.isFull()); // 输出 true

        // 测试出队操作
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 1
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 2

        // 测试队列状态
        System.out.println("Queue size: " + queue.size()); // 输出 3

        // 测试再次入队
        queue.enqueue(6);
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 3
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 4
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 5
        System.out.println("Dequeue: " + queue.dequeue()); // 输出 6

        // 队列应该为空
        System.out.println("Queue is empty: " + queue.isEmpty()); // 输出 true
    }
}
