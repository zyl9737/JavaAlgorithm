package me.icemoon.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yulong
 * @create 2025/7/3
 * @description
 */
public class _0017_letterCombinations {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        StringBuilder path = new StringBuilder();
        dfs(0, digits, path, res);
        return res;
    }

    private void dfs(int i, String digits, StringBuilder path, List<String> res) {
        if (i == digits.length()) {
            res.add(path.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        String letters = MAPPING[digit];
        for (char c : letters.toCharArray()) {
            path.append(c);
            dfs(i + 1, digits, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
