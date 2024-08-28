class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        boolean[][] vis = new boolean[grid2.length][grid2[0].length];
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1 && !vis[i][j]) {
                    if (dfs(i, j, grid1, grid2, vis)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int i, int j, int[][] g1, int[][] g2, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= g2.length || j >= g2[0].length || g2[i][j] == 0 || vis[i][j]) {
            return true;
        }
        vis[i][j] = true;
        boolean res = true;
        if (g1[i][j] == 0) {
            res = false;
        }

        res = dfs(i+1, j, g1, g2, vis) && res;
        res = dfs(i-1, j, g1, g2, vis) && res;
        res = dfs(i, j+1, g1, g2, vis) && res;
        res = dfs(i, j-1, g1, g2, vis) && res;

        return res;
    }
}