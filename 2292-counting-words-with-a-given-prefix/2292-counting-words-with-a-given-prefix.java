class Solution {
    public int prefixCount(String[] words, String pref) {
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            root.insert(words[i]);
        }
        return root.getPrefixCount(pref);
    }
}
class Trie {
    Trie child[];
    int count;
    Trie() {
        child = new Trie[26];
        count = 0;
    }
}
class Node {
    Trie root;
    Node() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie tmp = root;
        for (char c : word.toCharArray()) {
            if (tmp.child[c-'a'] == null) {
                tmp.child[c-'a'] = new Trie();
            }
            tmp = tmp.child[c-'a'];
            tmp.count++;
        }
    }

    public int getPrefixCount(String prefix) {
        Trie tmp = root;
        for (char c : prefix.toCharArray()) {
            if (tmp.child[c-'a'] == null) {
                return 0;
            }
            tmp = tmp.child[c-'a'];
        }
        return tmp.count;
    }
}