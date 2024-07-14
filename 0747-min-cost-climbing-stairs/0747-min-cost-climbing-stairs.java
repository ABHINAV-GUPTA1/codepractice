class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length+2];
        return Math.min(f(0, cost), f(1, cost));
        // return tabulation(cost);
    }

    // bottom up
    private int tabulation(int[] cost) {
        int n = cost.length;
        dp = new int[n+2];
        dp[n+1] = dp[n] = 0;
        dp[n-1] = cost[n-1];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    // topdown memoization
    private int f(int n, int[] arr) {
        if (n >= arr.length) {
            return 0;
        }
        if (n == arr.length-1) {
            return arr[n];
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = arr[n] + Math.min(f(n+1, arr), f(n+2, arr));
    } 
}