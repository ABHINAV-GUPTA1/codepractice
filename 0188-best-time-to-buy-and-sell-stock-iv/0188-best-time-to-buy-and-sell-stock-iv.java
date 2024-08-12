class Solution {
    int[][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[2*k+1][prices.length+1];
        
        for (int idx = prices.length-1; idx >= 0; idx--) {
            for (int trans = 2*k-1; trans >= 0; trans--) {
                if (trans%2 == 0) {
                    dp[trans][idx] = Math.max(-prices[idx]  + dp[trans+1][idx+1], dp[trans][idx+1]);
                } else {
                    dp[trans][idx] = Math.max(prices[idx]  + dp[trans+1][idx+1], dp[trans][idx+1]);          }
            }
        }
        return dp[0][0];
    }

    public int maxProfit1(int k, int[] prices) {
        dp = new int[2*k+1][prices.length];
        for (int i = 0; i <= 2*k; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, 2*k, prices);
    }

    int f(int idx, int trans, int maxTrans, int[] arr) {
        if (idx == arr.length || trans == maxTrans) {
            return 0;
        }
        if (dp[trans][idx] != -1) {
            return dp[trans][idx];
        }
        if (trans%2 == 0) {
            return dp[trans][idx] = Math.max(-arr[idx]  + f(idx+1, trans+1, maxTrans, arr), f(idx+1, trans, maxTrans, arr));
        }
        return dp[trans][idx] = Math.max(arr[idx]  + f(idx+1, trans+1, maxTrans, arr), f(idx+1, trans, maxTrans, arr));
    }
}