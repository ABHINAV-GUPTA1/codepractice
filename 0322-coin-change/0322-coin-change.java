class Solution {
    /**
        Method 3 : Space optimized
     */
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            if (amt%coins[0] == 0) {
                prev[amt] = amt / coins[0];
            } else {
                prev[amt] = MAX;
            }
        }
        for (int idx = 1; idx < coins.length; idx++) {
            
            for (int amt = 0; amt <= amount; amt++) {
                int ntake = prev[amt];
                int take = MAX;
                if (amt >= coins[idx]) {
                    take = 1 + curr[amt - coins[idx]];
                }

                curr[amt] = Math.min(ntake, take);
            }
            prev = Arrays.copyOf(curr, curr.length);

        }

        return prev[amount] >= MAX ? -1 : prev[amount];
    }

    /**
        Method 2 : DP
     */
    public int coinChange_method2(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int amt = 0; amt <= amount; amt++) {
            if (amt%coins[0] == 0) {
                dp[0][amt] = amt / coins[0];
            } else {
                dp[0][amt] = MAX;
            }
        }
        for (int idx = 1; idx < coins.length; idx++) {
            for (int amt = 0; amt <= amount; amt++) {
                int ntake = dp[idx - 1][amt];
                int take = MAX;
                if (amt >= coins[idx]) {
                    take = 1 + dp[idx][amt - coins[idx]];
                }

                dp[idx][amt] = Math.min(ntake, take);
            }
        }

        return dp[coins.length - 1][amount] >= MAX ? -1 : dp[coins.length - 1][amount];
    }

    /**
        Method 1 : recursion
     */
    private static int MAX = (int) 1e9;
    public int coinChange_method1(int[] coins, int amount) {
        int ans = f(coins, amount, coins.length - 1);
        return ans == MAX ? -1 : ans;
    }

    private int f(int[] arr, int amt, int idx) {
        if (idx == 0) {
            if (amt%arr[0] == 0) {
                return amt / arr[0];
            }
            return MAX;
        }
        
        int ntake = f(arr, amt, idx - 1);
        int take = MAX;
        if (amt >= arr[idx]) {
            take = 1 + f(arr, amt - arr[idx], idx);
        }

        return Math.min(ntake, take);
    }
}