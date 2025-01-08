class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            TrieHelper pre = new TrieHelper();
            TrieHelper suff = new TrieHelper();
            pre.insert(words[i]);
            suff.insert(new StringBuilder(words[i]).reverse().toString());

            for (int j = 0; j < i; j++) {
                if (words[j].length() > words[i].length()) {
                    continue;
                }
                String preWord = words[j];
                String suffWord = new StringBuilder(words[j]).reverse().toString();
                if (pre.startsWith(preWord) && suff.startsWith(suffWord)) {
                    ans++;
                }
            }
        }    
        return ans;
    }
}

class TrieHelper {
    Trie root;
    TrieHelper() {
        root = new Trie();
    }
    
    public void insert(String word) {
        Trie tmp = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new Trie();
            } 
            tmp = tmp.child[idx];
        }
    }

    public boolean startsWith(String word) {
        Trie tmp = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (tmp.child[idx] == null) {
                return false;
            }
            tmp = tmp.child[idx];
        }
        return true;
    }
}

class Trie {
    Trie[] child;
    Trie() {
        child = new Trie[26];
    }
}