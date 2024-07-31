class Solution {
    Trie root;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        dp = new Boolean[s.length()+1];
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }
        return solve(0, s);
    }

    private void insert(String s) {
        char[] arr = s.toCharArray();
        Trie tmp = root;
        int idx;
        for (int i = 0; i < arr.length; i++) {
            idx = arr[i] - 'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new Trie();
            }
            tmp = tmp.child[idx];
        }
        tmp.isEnd = true;
    }

    private boolean search(String s, int start, int end) {
        Trie tmp = root;
        char[] arr = s.toCharArray();
        int idx;
        end = Math.min(end, s.length());
        for (int i = start; i < end; i++) {
            idx = arr[i]-'a';
            if (tmp.child[idx] == null) {
                return false;
            }
            tmp = tmp.child[idx];
        }
        return tmp != null ? tmp.isEnd : false;
    }

    private boolean solve(int idx, String s) {
        if (idx >= s.length()) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            if (search(s, idx, i+1)) {
                if (solve(i+1, s)) {
                    return dp[idx] = true;
                }
            }
        }

        return dp[idx] = false;
    } 
}

class Trie {
    boolean isEnd = false;
    Trie[] child;
    Trie() {
        child = new Trie[26];
    }
}