package me.icemoon.hot100.sliding_windows;

import java.util.HashSet;
import java.util.Set;

public class _0003_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int l = 0;
        for (int r = 0; r < s.length; r++) {
            while (set.contains(s[r])) {
                set.remove(s[l]);
                l++;
            }
            set.add(s[r]);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}
