class TrieNode {
     TrieNode[] words;
    boolean isWord = false;
    TrieNode() {
        isWord = false;
         words = new TrieNode[26];
    }
}
class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char arr[] = word.toCharArray();
        TrieNode p = root;
        for (char c : arr) {
            if (p.words[c-'a'] == null) {
                p.words[c-'a'] = new TrieNode();
            }            
            p = p.words[c-'a'];
        }
        p.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            if (p.words[c-'a'] == null) {
                return false;
            }
            p = p.words[c-'a'];
        }
        return p.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c : prefix.toCharArray()) {
            if (p.words[c-'a'] == null) {
                return false;
            }
            p = p.words[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */