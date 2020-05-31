package com.zhk.Trie;
//leetcode 208. 实现 Trie (前缀树)

class TrieNode {
    private static final int R = 26;
    private TrieNode[] links;
    private boolean isEnd;

    TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void set(char ch, TrieNode node) {
        links[ch - 'a'] = node;

    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    /**
     * Initialize your data structure here.
     */
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containKey(ch)) {
                TrieNode newNode = new TrieNode();
                node.set(ch, newNode);
            }
            node = node.get(ch);

        }
        node.setEnd();

    }
    TrieNode searchNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node =  searchNode(word);
        return node!=null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        TrieNode node =  searchNode(prefix);
        return node!=null ;
    }

    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("app");
        System.out.println("Trie.main ==> "+ tr.search("app"));
        System.out.println("Trie.main ==> " + tr.search("apple"));
        tr.insert("apple");
        System.out.println("Trie.main ==> " + tr.search("apple"));

    }
}
