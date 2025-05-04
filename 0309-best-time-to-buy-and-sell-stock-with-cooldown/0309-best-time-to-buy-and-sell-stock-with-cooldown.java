class Solution {
    
    /**
        Bottom up space optimised
     */
    public int maxProfit(int[] prices) {
        int[] curr = new int[2];
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            curr[1] = Math.max(-prices[idx] + prev1[0], prev1[1]);
            curr[0] = Math.max(prices[idx] + prev2[1], prev1[0]);
            System.arraycopy(prev1, 0, prev2, 0, 2); // prev2 = prev1
            System.arraycopy(curr, 0, prev1, 0, 2); // prev1 = curr
        }
        return curr[1];
    }

    /**
        Bottom up/tabulation
     */
    public int maxProfit_method2(int[] prices) {
        dp = new int[prices.length+2][2];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1) {
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx+1][0], dp[idx+1][buy]);
                } else {
                    dp[idx][buy] = Math.max(prices[idx] + dp[idx+2][1], dp[idx+1][buy]);
                }
            }
        }
        return dp[0][1];
    }

    /**
        Memoization solution
     */
    int[][] dp;
    public int maxProfit_method1(int[] prices) {
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