class Solution {
    public int minDays(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int island = numIsland(grid);
        if (island > 1 || island == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    island = numIsland(grid);
                    if (island > 1 || island == 0) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int numIsland(int[][] grid) {
        int island = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, vis, grid);
                    island++;
                }
            }
        }
        return island;
    }

    private void dfs(int i, int j, boolean[][] vis, int[][] arr) {
        if (i < 0 || j < 0 || i >= vis.length || j >= arr[i].length || arr[i][j] == 0 || vis[i][j]) {
            return;
        }
        vis[i][j] = true;
        dfs(i+1, j, vis, arr);
        dfs(i-1, j, vis, arr);
        dfs(i, j+1, vis, arr);
        dfs(i, j-1, vis, arr);
    }
}