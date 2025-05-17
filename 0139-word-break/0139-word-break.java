class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
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