class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length+1][2];
        for (int i = 0; i <= prices.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return f(0, 1, prices);    
    }

    int f(int idx, int buy, int[] arr) {
        if (idx >= arr.length) {
            return 0;
        }
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        if (buy == 1) {
            return dp[idx][buy] = Math.max(-arr[idx] + f(idx+1, 0, arr), f(idx+1, buy, arr));
        }
        return dp[idx][buy] = Math.max(arr[idx] + f(idx+2, 1, arr), f(idx+1, buy, arr));
    }
}