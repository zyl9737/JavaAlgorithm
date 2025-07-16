package me.icemoon.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yulong
 * @create 2025/7/15
 * @description 394. 字符串解码
 */
public class _0394_decodeString {
    public String decodeString(String s) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<StringBuilder> s2 = new ArrayDeque<>();
        int num = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                s1.push(num);
                s2.push(res);
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = res;
                res = s2.pop();
                int repeatTimes = s1.pop();
                while (repeatTimes-- > 0) {
                    res.append(temp);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        _0394_decodeString solution = new _0394_decodeString();
        String result = solution.decodeString("3[a2[c]]");
        System.out.println(result); // 输出 "accaccacc"
    }
}
