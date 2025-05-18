class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int left = 0;
                if (i > 0) {
                    left = dp[i - 1][j];
                }
                int up = 0;
                if (j > 0) {
                    up = dp[i][j - 1];
                }
                dp[i][j] =  left + up;
            }
        }

        return dp[m - 1][n - 1];
    }

    /**

        Method 1 : recursion
     */
    Integer[][] dp;
    public int uniquePaths_method1(int m, int n) {
        dp = new Integer[m][n];
        return f(m - 1, n - 1);
    }

    private int f(int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != null) {
            return dp[m][n];
        }
        int left = f(m-1, n);
        int up = f(m, n - 1);

        return dp[m][n] =  left + up;
    }
}