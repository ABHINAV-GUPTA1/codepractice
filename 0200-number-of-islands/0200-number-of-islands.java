class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    int[] dx = {-1, 0,  1, 0};
    int[] dy = {0,  -1, 0, 1};
    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || vis[row][col] || grid[row][col] == '0') {
            return;
        }
        vis[row][col] = true;
        int nr;
        int nc;
        for (int i = 0; i < dx.length; i++) {
            nr = row + dx[i];
            nc = col + dy[i];
            dfs(nr, nc, grid, vis);
        }
    }
}