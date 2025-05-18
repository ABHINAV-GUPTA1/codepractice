class Solution {
    class Tmp {
        int start, end;
        Tmp(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TrieNode root;

    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();    
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            insert(word);
        }

        for (int i = 0; i < s.length(); i++) {
            if (search(s, 0, i + 1)) {
                List<Tmp> tmp = new ArrayList<>();
                tmp.add(new Tmp(0, i + 1));
                solve(i + 1, tmp, s, res);
            }
        }

        return res;
    }

    private String getStr(List<Tmp> tmps, String s) {
        StringBuilder sb = new StringBuilder();
        for (Tmp tmp : tmps) {
            if (tmp.start == -1) {
                sb.append(" ");
            } else {
                sb.append(s.substring(tmp.start, tmp.end));
            }
        }

        return sb.toString();
    }

    private void solve(int idx, List<Tmp> tmp, String s, List<String> res) {
        if (idx == s.length()) {
            res.add(getStr(tmp, s));
            return;
        }
        tmp.add(new Tmp(-1, -1));
        for (int i = idx; i < s.length(); i++) {
            if (search(s, idx, i + 1)) {
                tmp.add(new Tmp(idx, i+1));
                solve(i+1, tmp, s, res);
                tmp.remove(tmp.size() - 1);
            }
        }
        tmp.remove(tmp.size() - 1);
    }

    private boolean search (String s, int start, int end) {

        TrieNode tmp = root;

        for (int i = start; i < end; i++) {
            int idx = s.charAt(i) - 'a';
            if (tmp.child[idx] == null) {
                return false;
            }
            tmp = tmp.child[idx];
        }

        return tmp != null && tmp.word > 0;
    }

    private void insert(String s) {
        TrieNode tmp = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (tmp.child[idx] == null) {
                tmp.child[idx] = new TrieNode();
            }
            tmp = tmp.child[idx];
        }

        tmp.word++;
    }
}

class TrieNode {
    int word;
    TrieNode[] child;
    TrieNode() {
        word = 0;
        child = new TrieNode[26];
    }
}