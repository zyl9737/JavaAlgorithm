package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/15
 * @description 20. 有效的括号
 */
public class _0020_isValid {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // 奇数长度的字符串不可能是有效括号
        }

        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) {
                return false; // 如果栈为空或栈顶元素不匹配，则不是有效括号
            }
        }
        return st.isEmpty(); // 如果栈为空，则所有括号都匹配成功
    }
}
