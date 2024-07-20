class Solution {
    int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return f(0, n-1, nums) >= 0;
    }

    private int f(int i, int j, int[] arr) { 
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return arr[i];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int takei = arr[i] - f(i+1, j, arr);
        int takej = arr[j] - f(i, j-1, arr);

        return dp[i][j] = Math.max(takei, takej);
    }
}