class Solution {
    /**
        Bottom up based on Transaction count space optimised 
     */
    public int maxProfit(int[] prices) {
        int[] curr = new int[5];
        int[] prev = new int[5];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int trans = 3; trans >= 0; trans--) {
                int profit = 0;
                if (trans%2 == 0) {
                    profit = Math.max(-prices[idx] + prev[trans+1], prev[trans]);
                } else {
                    profit = Math.max(prices[idx] + prev[trans+1], prev[trans]);
                }
                curr[trans] = profit;
            }
            prev = curr;
        }
        return prev[0];
    }

    /**
        Transaction count based iterative
     */
    public int maxProfit_method6(int[] prices) {
        int[][] dpp = new int[prices.length+1][5];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int trans = 3; trans >= 0; trans--) {
                int profit = 0;
                if (trans%2 == 0) {
                    profit = Math.max(-prices[idx] + dpp[idx+1][trans+1], dpp[idx+1][trans]);
                } else {
                    profit = Math.max(prices[idx] + dpp[idx+1][trans+1], dpp[idx+1][trans]);
                }
                dpp[idx][trans] = profit;
            }
        }
        return dpp[0][0];
    }

    /**
        Transaction count based recursive solution
     */
    public int maxProfit_method5(int[] prices) {
        int trans = 0;
        return func(prices, 0, trans);
    }
    
    private int func(int[] arr, int idx, int trans) {
        if (idx >= arr.length || trans == 4) {
            return 0;
        }
        int profit = 0;
        if (trans%2 == 0) {
            profit = Math.max(-arr[idx] + func(arr, idx+1, trans+1), func(arr, idx+1, trans));
        } else {
            profit = Math.max(arr[idx] + func(arr, idx+1, trans+1), func(arr, idx+1, trans));
        }

        return profit;
    }
    
    /**
        Tabular or bottom up Space optimised approach 
     */
    public int maxProfit_method4(int[] prices) {
        // dp[buy][cap][arr length]
        // dp = new int[2][3][prices.length+1];
        //cap = 0 then dp[0->2][0][0->length] = 0
        //idx >= length then dp[0->2][0->3][>=length] = 0
        int[][] curr = new int[2][3];
        int[][] prev = new int[2][3];
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int profit = 0;
                    if(buy == 1) {
                        profit = Math.max(-prices[idx] + prev[0][cap], prev[buy][cap]);
                    } else {
                        profit = Math.max(prices[idx] + prev[1][cap - 1], prev[buy][cap]);
                    }
                    curr[buy][cap] = profit;
                }
            }
            prev = curr;
        }

        return prev[1][2];
    }

    /**
        Tabular or bottom up approach 
     */
    public int maxProfit_method3(int[] prices) {
        // dp[buy][cap][arr length]
        dp = new int[2][3][prices.length+1];
        //cap = 0 then dp[0->2][0][0->length] = 0
        //idx >= length then dp[0->2][0->3][>=length] = 0

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int profit = 0;
                    if(buy == 1) {
                        profit = Math.max(-prices[idx] + dp[0][cap][idx+1], dp[buy][cap][idx+1]);
                    } else {
                        profit = Math.max(prices[idx] + dp[1][cap - 1][idx+1], dp[buy][cap][idx+1]);
                    }
                    dp[buy][cap][idx] = profit;
                }
            }
        }

        return dp[1][2][0];
    }

    /**
        Memoization solution
     */
    int[][][] dp;
    public int maxProfit_method2(int[] prices) {
        // dp[buy][cap][arr length]
        dp = new int[2][3][prices.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f1(prices, 0, 1, 2);
    }

    private int f1(int[] prices, int idx, int buy, int cap) {
        if (cap == 0) {
            return 0;
        }
        if (idx >= prices.length) {
            return 0;
        }
        if (dp[buy][cap][idx] != -1) {
            return dp[buy][cap][idx];
        }
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + f1(prices, idx+1, 0, cap), f1(prices, idx+1, buy, cap));
        } else {
            profit = Math.max(prices[idx] + f1(prices, idx+1, 1, cap - 1), f1(prices, idx+1, buy, cap));
        }

        return dp[buy][cap][idx] = profit;
    }

    /**
        Recursive solution
     */
    public int maxProfit_method1(int[] prices) {
        return f(prices, 0, 1, 2);
    }

    private int f(int[] prices, int idx, int buy, int cap) {
        if (cap == 0) {
            return 0;
        }
        if (idx >= prices.length) {
            return 0;
        }
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[idx] + f(prices, idx+1, 0, cap), f(prices, idx+1, buy, cap));
        } else {
            profit = Math.max(prices[idx] + f(prices, idx+1, 1, cap - 1), f(prices, idx+1, buy, cap));
        }

        return profit;
    }
}