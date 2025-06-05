package me.icemoon.hot100.tree;

import me.icemoon.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Yulong
 * @create 2025/6/5
 * @description 翻转二叉树
 * 优先选择自根向叶（前序：逻辑直白，符合“先操作当前节点再处理子树”的常规递归思维，调试更直观
 * 。
 * 理解自叶向根的价值：在需要先获取子问题结果的场景（如计算子树高度）更适用，体现分治思想
 */
public class _0226_invertTree {
    // 自叶向根
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 自根向叶
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }

    // 栈模拟前序，但路径因交换而改变（沿原右子树深入）
    // 时间复杂度 O(n)，空间复杂度 O(h)（栈空间）
    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                // 关键：转向新的左子树（原右子树）
                cur = cur.left;
            }
            // 左子树处理完毕，回溯到栈顶节点
            if (!st.isEmpty()) {
                cur = st.pop();
                cur = cur.right; // 处理右子树
            }
        }
        return root;
    }

    // 层序遍历（广度优先）
    public TreeNode invertTree4(TreeNode root) {
        if (root == null) {return null;}
        Queue<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) {deque.offer(node.left);}
                if (node.right != null) {deque.offer(node.right);}
            }
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
