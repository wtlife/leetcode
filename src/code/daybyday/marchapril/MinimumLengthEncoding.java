package code.daybyday.marchapril;

import java.util.Arrays;

public class MinimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }


    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public int insert(String s) {
            int len = s.length();
            boolean isNew = false;
            TrieNode cur = root;
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                int index = c - 'a';
                if (cur.children[index] == null) {
                    isNew = true;
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];

            }
            return isNew ? s.length() + 1 : 0;
        }
    }

    class TrieNode {
        char val;

        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }
}
