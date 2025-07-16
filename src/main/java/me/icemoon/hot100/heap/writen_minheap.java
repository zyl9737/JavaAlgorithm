package me.icemoon.hot100.heap;

/**
 * @author Yulong
 * @create 2025/7/16
 * @description
 */
public class writen_minheap {
    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(k + 1);
        for (int i = 0; i < nums.length; i++) {
            if (!heap.push(nums[i])) {
                heap.pop();
                heap.push(nums[i]);
            }
        }
        if (heap.size == k + 1)
            heap.pop();
        return heap.peek();
    }

    class Heap {
        int size = 0;
        int[] heap;

        public Heap(int len) {
            heap = new int[len + 1];
        }

        public boolean push(int val) {
            if (size == heap.length - 1)
                return false;
            heap[++size] = val;
            shiftUp(size);
            return true;
        }

        public int pop() {
            int val = heap[1];
            heap[1] = heap[size];
            heap[size--] = 0;
            shiftDown(1);
            return val;
        }

        public int peek() {
            return heap[1];
        }

        private void shiftUp(int i) {
            int val = heap[i];
            while ((i >> 1) > 0) {
                int parent = i >> 1;
                if (val < heap[parent]) {
                    heap[i] = heap[parent];
                    i = parent;
                } else {
                    break;
                }
            }
            heap[i] = val;
        }

        private void shiftDown(int i) {
            int val = heap[i];
            while ((i << 1) <= size) {
                int child = i << 1;
                if (child != size && heap[child + 1] < heap[child])
                    child++;
                if (val > heap[child]) {
                    heap[i] = heap[child];
                    i = child;
                } else {
                    break;
                }
            }
            heap[i] = val;
        }
    }

    public static void main(String[] args) {
        writen_minheap solution = new writen_minheap();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println(result); // 输出 5
    }
}

