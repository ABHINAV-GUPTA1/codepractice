class Solution {
    int dp[];
    public int climbStairs(int n) {
        // dp = new int[n+1];
        // return f(n);

        dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    int f(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = f(n-1) + f(n-2);
    }
}