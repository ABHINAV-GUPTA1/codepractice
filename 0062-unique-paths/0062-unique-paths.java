class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
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