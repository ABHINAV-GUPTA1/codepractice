//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, String[] dictionary) {
        Trie root = new Trie();
        for (String dict : dictionary) {
            insert(dict, root);
        }
        dp = new Boolean[s.length()+1];
        return isWordBreak(0, s, root);
    }
    
    private boolean isWordBreak(int idx, String s, Trie root) {
        if (idx >= s.length()) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        for (int i = idx; i < s.length(); i++) {
            if (isSearch(idx, i + 1, s, root) && isWordBreak(i + 1, s, root)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    
    private boolean isSearch(int start, int end, String s, Trie root) {
        Trie t = root;
        end = Math.min(end, s.length());
        for (int i = start; i < end; i++) {
            if (t.child[s.charAt(i)] == null) {
                return false;
            }
            t = t.child[s.charAt(i)];
        }
        return t != null && t.isEnd;
    }
    
    private void insert(String word, Trie root) {
        Trie t = root;
        for (int i = 0; i < word.length(); i++) {
            if (t.child[word.charAt(i)] == null) {
                t.child[word.charAt(i)] = new Trie();
            } 
            t = t.child[word.charAt(i)];
        }
        t.isEnd = true;
    }
}

class Trie {
    Trie[] child;
    boolean isEnd;
    Trie() {
        child = new Trie[256];
    }
}