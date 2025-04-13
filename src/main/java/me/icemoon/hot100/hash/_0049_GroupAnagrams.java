package me.icemoon.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(m.values());
    }
}
