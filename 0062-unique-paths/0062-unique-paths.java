class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(m-1, n-1);
    }

    int f(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int p1 = f(m-1, n);
        int p2 = f(m, n-1);

        return dp[m][n] = p1+p2;
    }
}