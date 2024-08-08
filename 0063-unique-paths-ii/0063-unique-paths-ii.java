class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(m-1, n-1, obstacleGrid);
    }

    int f(int m, int n, int[][] arr) {
        if (m < 0 || n < 0 || arr[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int p1 = f(m-1, n, arr);
        int p2 = f(m, n-1, arr);
        return dp[m][n] = p1+p2;
    }
}