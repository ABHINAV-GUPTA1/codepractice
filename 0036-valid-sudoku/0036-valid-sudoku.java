class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        String str;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                sb = new StringBuilder("(").append(board[i][j]).append(")");
                str = sb.toString();
                if (!set.add(str+i) || !set.add(j+str) || !set.add((i/3)+str+(j/3))) {
                    return false;
                }
            }
        }

        return true;
    }
}