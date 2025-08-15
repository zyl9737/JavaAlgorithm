package me.icemoon.hot150.array;

/**
 * @author Yulong
 * @create 2025/8/11
 * @description
 */
public class _0014_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String s0 = strs[0];
        for (int j = 0; j < s0.length(); j++) { // 从左到右
            char c = s0.charAt(j);
            for (String s : strs) { // 从上到下
                if (j == s.length() || s.charAt(j) != c) { // 这一列有字母缺失或者不同
                    return s0.substring(0, j); // 0 到 j-1 是公共前缀
                }
            }
        }
        return s0;
    }
}
