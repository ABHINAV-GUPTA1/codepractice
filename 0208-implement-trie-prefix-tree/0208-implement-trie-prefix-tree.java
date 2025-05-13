class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    TrieNode() {
        child = new TrieNode[26]; 
    }
} 
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tmp = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new TrieNode();
            }
            tmp = tmp.child[idx];
        }
        tmp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode tmp = searchInTrieNode(word);
        return tmp != null ? tmp.isEnd : false;
    }

    private TrieNode searchInTrieNode(String word) {
        int len = word.length();
        TrieNode tmp = root;
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (tmp.child[idx] == null) {
                return null;
            }
            tmp = tmp.child[idx];
        }
        return tmp;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode tmp = searchInTrieNode(prefix);
        return tmp != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */