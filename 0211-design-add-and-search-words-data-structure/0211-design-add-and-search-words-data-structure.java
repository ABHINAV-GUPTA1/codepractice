class TrieNode {
    TrieNode child[];
    boolean isEnd;
    TrieNode() {
        this.child = new TrieNode[26];
    }
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        TrieNode tmp = root;
        return search(tmp, word, 0);
    }

    private boolean search(TrieNode tmp, String word, int idx) {
        if (idx == word.length()) {
            return tmp != null && tmp.isEnd;
        }

        for (int i = idx; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j = 0; j < 26; j++) {
                    if (tmp.child[j] == null) {
                        continue;
                    }
                    if (search(tmp.child[j], word, i + 1)) {
                        return true;
                    }
                }
                return false;
            }
            int trieIdx = word.charAt(i) - 'a';
            if (tmp.child[trieIdx] == null) {
                return false;
            }
            tmp = tmp.child[trieIdx];
        }

        return tmp != null ? tmp.isEnd : false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */