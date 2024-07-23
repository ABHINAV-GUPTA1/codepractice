class WordDictionary {

    Trie root;

    public WordDictionary() {
        root = new Trie();    
    }
    
    public void addWord(String word) {
        insert(word);
    }
    
    private void insert(String word) {
        char[] arr = word.toCharArray();
        Trie tmp = root;
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i]-'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new Trie();
            }
            tmp = tmp.child[idx];
        }
        tmp.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, Trie t) {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int a = 0; a < 26; a++) {
                    if (t.child[a] != null && search(word, i+1, t.child[a]) ) {
                        return true;
                    }
                }
                return false;
            }
            int idxi = c-'a';
            if (t.child[idxi] == null) {
                return false;
            }
            t = t.child[idxi];
        }
        return t.isEnd;
    }

}

class Trie {
    Trie[] child;
    boolean isEnd=false;

    Trie() {
        child = new Trie[26];
        isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */