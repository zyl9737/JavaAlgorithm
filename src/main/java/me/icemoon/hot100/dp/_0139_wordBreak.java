package me.icemoon.hot100.dp;

import java.util.List;

/**
 * @author Yulong
 * @create 2025/7/18
 * @description
 */
public class _0139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 空字符串可以被分解
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break; // 找到一个匹配就可以跳出循环
                }
            }
        }
        return dp[s.length()]; // 返回是否可以分解整个字符串
    }
}
