package me.icemoon.nowcoder.writen;

import java.util.Stack;

/**
 * @author Yulong
 * @create 2025/5/30
 * @description
 */
public class _0002_IsPopOrder {
    public boolean IsPopOrder (int[] pushV, int[] popV) {
        if (pushV == null || popV == null || pushV.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while (!stack.isEmpty() && j < popV.length && stack.peek() == popV[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty() && j == popV.length;
    }
}
