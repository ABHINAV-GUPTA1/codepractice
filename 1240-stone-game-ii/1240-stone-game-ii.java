class Solution {
    int[] prefSum;
    int[][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        prefSum = new int[n];
        prefSum[n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--) {
            prefSum[i] = prefSum[i+1] + piles[i];
        }
        return f(1, 0, piles);
    }

    int f(int m, int idx, int[] arr) {
        if (idx >= arr.length) {
            return 0;
        }

        if (2*m >= arr.length-idx) {
            return prefSum[idx];
        }
        if (dp[m][idx] != -1) {
            return dp[m][idx];
        }
        int ans = Integer.MAX_VALUE;
        int max = Math.min(2*m, arr.length-1);
        int sum = arr[idx];
        for (int x = 1; x <= max ; x++) {
            ans = Math.min(ans, f(Math.max(m, x), idx+x, arr));
        }

        return dp[m][idx] = prefSum[idx] - ans;
    }
}