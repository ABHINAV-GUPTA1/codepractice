class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length+1][2];
        for (int i = 0; i <= prices.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return f(0, 1, fee, prices);
    }

    int f(int idx, int buy, int fee, int[] arr) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        if (buy == 1) {
            return dp[idx][buy] = Math.max(-arr[idx] + f(idx+1, 0, fee, arr), f(idx+1, buy, fee, arr));
        }
        return dp[idx][buy] = Math.max(arr[idx] - fee + f(idx+1, 1, fee, arr), f(idx+1, buy, fee, arr));
    }
}