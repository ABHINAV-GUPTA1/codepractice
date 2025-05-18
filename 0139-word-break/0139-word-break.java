class Solution {
    /**
        Method3 :trie 
     */
    TrieNode root;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        dp = new Boolean[s.length() + 1];
        for (String word : wordDict) {
            insert(root, word);
        }
        return solve(s, 0);
    }

    private boolean search(String s, int start, int end) {
        TrieNode tmp = root;
        for (int i = start; i < end; i++) {
            int idx = s.charAt(i) - 'a';
            if (tmp.child[idx] == null) {
                return false;
            }
            tmp = tmp.child[idx];
        }
        return tmp != null && tmp.isEnd;
    }

    private boolean solve(String s, int idx) {
        if (idx >= s.length()) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        for (int i = idx; i < s.length(); i++) {
            if (search(s, idx, i + 1)) {
                if (solve(s, i + 1)) {
                    return dp[idx] = true;
                }
            }
        }
        
        return dp[idx] = false;
    }

    private void insert(TrieNode root, String s) {
        TrieNode tmp = root;
        for (char c: s.toCharArray()) {
            int idx = c - 'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new TrieNode();
            } 
            tmp = tmp.child[idx];
        }

        tmp.isEnd = true;
    }

    /**
        Method2: DP
     */
    public boolean wordBreak_method2(String s, List<String> wordDict) {
        Boolean[] visit = new Boolean[s.length() + 1];
        visit[s.length()] = true;
        for (int idx = s.length() - 1; idx >= 0; idx--) {
            for (String word : wordDict) {
                if (idx <= s.length() && s.startsWith(word, idx)) {
                    if (idx+word.length() <= s.length() && visit[idx + word.length()]) {
                        visit[idx] = true;
                        break;
                    }        
                }
            }
            if (visit[idx] == null) {
                visit[idx] = false;
            }
        }

        return visit[0];
    }

    /**
        Method 1 : recursion
     */
    public boolean wordBreak_method1(String s, List<String> wordDict) {
        return f(s, wordDict, 0, new Boolean[s.length() + 1] );
    }

    private boolean f(String s, List<String> words, int idx, Boolean[] visit) {
        if (visit[idx] != null) {
            return visit[idx];
        }
        if (idx >= s.length()) {
            return visit[idx] = true;
        }
        for (String word : words) {
            if (idx <= s.length() && s.startsWith(word, idx)) {
                if (f(s, words, idx + word.length(), visit)) {
                    visit[idx] = true;
                    return true;
                }        
            }
        }

        return visit[idx] = false;  
    }
}
class TrieNode {
    boolean isEnd;
    TrieNode[] child;
    TrieNode() {
        child = new TrieNode[26];
    }
}