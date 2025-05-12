class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = addWordsInTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    dfs (board, i, j, res, root);
                }
            }
        }    

        return res;
    }

    private void dfs(char[][] board, int i, int j, List<String> res, Trie root) {
        char c = board[i][j];
        if (c == '$' || root.child[c - 'a'] == null) {
            return;
        }
        root = root.child[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '$';
        if (i - 1 >= 0) {
            dfs(board, i - 1, j, res, root);
        }
        if (i + 1 < board.length) {
            dfs(board, i + 1, j, res, root);
        }
        if (j - 1 >= 0) {
            dfs(board, i, j - 1, res, root);
        }
        if (j + 1 < board[0].length) {
            dfs(board, i, j + 1, res, root);
        }
        board[i][j] = c;
    }
    
    private Trie addWordsInTrie(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            addWordInTrie(trie, word);
        }
        return trie;
    }

    private void addWordInTrie(Trie trie, String word) {
        char[] arr = word.toCharArray();
        Trie root = trie;
        for (int i = 0; i < arr.length; i++) {
            if (root.child[arr[i] - 'a'] == null) {
                root.child[arr[i] - 'a'] = new Trie();
            }
            root = root.child[arr[i] - 'a'];
        }
        root.word = word;
    }
}

class Trie {
    String word;
    Trie[] child;
    Trie() {
        child = new Trie[26];
    }
}