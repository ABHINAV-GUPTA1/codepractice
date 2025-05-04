class Solution {

    /**
        Tabulation/bottomup : Space optimised
     */
    public int maxProfit(int[] prices) {
        int curr[] = new int[2];
        int prev[] = new int[2];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max(-prices[idx] + prev[0], prev[buy]);
                } else {
                    profit = Math.max(prices[idx] + prev[1], prev[buy]);
                }

                curr[buy] = profit;
            }
            prev = curr;
        }

        return prev[1];

    }

    /**
        Tabulation/bottomup
     */
    public int maxProfit_method3(int[] prices) {
        dp = new int[2][prices.length+1];
        //dp[0][prices.length] = dp[1][prices.length] = 0;

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max(-prices[idx] + dp[0][idx+1], dp[buy][idx+1]);
                } else {
                    profit = Math.max(prices[idx] + dp[1][idx+1], dp[buy][idx+1]);
                }

                dp[buy][idx] = profit;
            }
        }

        return dp[1][0];

    }

    /**
        Memoization solution
     */
    int[][] dp;
    public int maxProfit_method2(int[] prices) {
        dp = new int[2][prices.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return f1(prices, 0, 1);
    }

    private int f1(int[] prices, int idx, int buy) {
        if (idx >= prices.length) {
            return 0;
        }
        if (dp[buy][idx] != -1) {
            return dp[buy][idx];
        }
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + f1(prices, idx+1, 0), f1(prices, idx+1, buy));
        } else {
            profit = Math.max(prices[idx] + f1(prices, idx+1, 1), f1(prices, idx+1, buy));
        }

        return dp[buy][idx] = profit;
    }

    /**
        Recursive solution
     */
    public int maxProfit_method1(int[] prices) {
        return f(prices, 0, 1);
    }

    private int f(int[] prices, int idx, int buy) {
        if (idx >= prices.length) {
            return 0;
        }
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + f(prices, idx+1, 0), f(prices, idx+1, buy));
        } else {
            profit = Math.max(prices[idx] + f(prices, idx+1, 1), f(prices, idx+1, buy));
        }

        return profit;
    }
}