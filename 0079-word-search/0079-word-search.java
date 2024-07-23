class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(i, j, word, board, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String word, char[][] board, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return false;
        }
        if (word.charAt(idx) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        if (dfs(i+1,j, word, board, idx+1) || dfs(i,j+1, word, board, idx+1) || dfs(i,j-1, word, board, idx+1) || dfs(i-1,j, word, board, idx+1)) {
            return true;
        }
        board[i][j] = t;
        return false;
    }

}