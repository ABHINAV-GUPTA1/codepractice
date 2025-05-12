class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        if (word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }    
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(k)) {
            return false;
        } 
        board[i][j] = '$';
        if (dfs(board, word, i + 1, j, k+1)
            || dfs(board, word, i - 1, j, k+1)
            || dfs(board, word, i, j + 1, k+1)
            || dfs(board, word, i, j - 1, k+1)) {
            board[i][j] = word.charAt(k);
            return true;        
            }
        board[i][j] = word.charAt(k);
        return false;
    }
}