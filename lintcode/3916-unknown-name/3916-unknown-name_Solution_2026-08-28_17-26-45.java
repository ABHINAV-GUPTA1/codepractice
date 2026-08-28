public class Solution {
    /**
     * @param grid: An array of strings
     * @param word: A string
     * @return: Check if word can be placed in crossword
     */
    public boolean placeWordInCrossword(char[][] grid, String word) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;
        String rev = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                while (j < n && grid[i][j] == 'X') j++;
                int start = j;
                while (j < n && grid[i][j] != 'X') j++;
                int len = j - start;

                if (len == word.length()) {
                    if (matchRow(grid, i, start, word) ||
                        matchRow(grid, i, start, rev))
                        return true;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < m) {
                while (i < m && grid[i][j] == 'X') i++;
                int start = i;
                while (i < m && grid[i][j] != 'X') i++;
                int len = i - start;

                if (len == word.length()) {
                    if (matchCol(grid, start, j, word) ||
                        matchCol(grid, start, j, rev))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean matchRow(char[][] grid, int row, int col, String word) {
        for (int k = 0; k < word.length(); k++) {
            char ch = grid[row][col + k];
            if (ch != 'O' && ch != word.charAt(k))
                return false;
        }
        return true;
    }

    private boolean matchCol(char[][] grid, int row, int col, String word) {
        for (int k = 0; k < word.length(); k++) {
            char ch = grid[row + k][col];
            if (ch != 'O' && ch != word.charAt(k))
                return false;
        }
        return true;
    }
}