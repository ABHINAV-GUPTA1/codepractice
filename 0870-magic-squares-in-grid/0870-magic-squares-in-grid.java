class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m-2; i++) {
            for (int j = 0; j < m-2; j++) {
                ans += magic(i, j, grid);
            }
        }

        return ans;
    }

    private int magic(int r, int c, int[][] grid) {
        Set<Integer> set = new HashSet<>();
        for (int i = r; i < r+2; i++) {
            for (int j = c; j < c+2; j++) {
                int val = grid[i][j];
                if (!(val >= 1 && val <= 9) || set.contains(val)) {
                    return 0;
                }
                set.add(val);
            }
        }
        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        for (int i = r; i <= r+2; i++) {
            col1 += grid[i][c];
            col2 += grid[i][c+1];
            col3 += grid[i][c+2];
        }
        if (!(col1 == 15 && col2 == 15 && col3 == 15)) {
            return 0;
        }
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        for (int i = c; i <= c+2; i++) {
            row1 += grid[r][i];
            row2 += grid[r+1][i];
            row3 += grid[r+2][i];
        }
        if (!(row1 == 15 && row2 == 15 && row3 == 15)) {
            return 0;
        }
        int diag1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int diag2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if (diag1 != 15 || diag2 != 15) {
            return 0;
        }
        return 1;
    }
}