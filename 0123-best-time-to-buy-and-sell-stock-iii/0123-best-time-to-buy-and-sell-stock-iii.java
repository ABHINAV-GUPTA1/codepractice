class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][4];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f (0, 0, prices);
    }

    int f(int idx, int trans, int[] prices) {
        if (idx == prices.length || trans == 4) {
            return 0;
        }
        if (dp[idx][trans] != -1) {
            return dp[idx][trans];
        }
        if (trans%2 == 0) {
            return dp[idx][trans] = Math.max(-prices[idx]+f(idx+1, trans+1, prices), f(idx+1, trans, prices));
        }
        return dp[idx][trans] = Math.max(prices[idx]+f(idx+1, trans+1, prices), f(idx+1, trans, prices));
    }
}