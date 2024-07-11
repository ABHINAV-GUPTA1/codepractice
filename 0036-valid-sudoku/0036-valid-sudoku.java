class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        String st;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                sb = new StringBuilder("(").append(board[i][j]).append(")");
                st = sb.toString();
                int sz = sb.length();
                if (!set.add(st+i) || !set.add(j+st) || !set.add((i/3) + st + (j/3) )) {
                    return false;
                }
            }

        }
        return true;
    }
}