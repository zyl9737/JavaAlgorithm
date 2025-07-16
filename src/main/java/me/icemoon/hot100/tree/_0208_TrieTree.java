package me.icemoon.hot100.tree;

/**
 * @author Yulong
 * @create 2025/7/2
 * @description
 */
public class _0208_TrieTree {

    private static class Node {
        Node[] son = new Node[26];
        boolean isEnd = false;
    }
    private Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) > 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                return 0;
            }
            cur = cur.son[c];
        }
        return cur.isEnd ? 2 : 1;
    }

    public static void main(String[] args) {
        _0208_TrieTree trie = new _0208_TrieTree();
        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.startsWith("ap"));  // true
        System.out.println(trie.search("banana"));   // false
    }
}
