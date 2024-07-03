class Solution {
    /**
        Method 1
     */
    int[][] dp;
    public int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(coins.length-1, amount, coins);
        return ans >= (int)1e9 ? -1 : ans;
    }

    int f(int idx, int target, int[] arr) {
        if (idx == 0) {
            if (target%arr[idx] == 0) {
                return target/arr[idx];
            }
            return (int)1e9;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int ntake = f(idx-1, target, arr);
        int take = Integer.MAX_VALUE;
        if (arr[idx] <= target) {
            take = 1 + f(idx, target-arr[idx], arr);
        }
        return dp[idx][target] = Math.min(take, ntake);
    }

    /**
        Method 2
     */
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = i%coins[0] == 0 ? i/coins[0] : (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int ntake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    take = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, ntake);    
            }
        }

        return dp[n-1][amount] >= (int)1e9 ? -1 : dp[n-1][amount];
    }

    /**
        Method 3
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp = new int[n][amount+1];
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        
        for (int i = 0; i <= amount; i++) {
            prev[i] = i%coins[0] == 0 ? i/coins[0] : (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int ntake = prev[j];
                int take = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    take = 1 + curr[j-coins[i]];
                }
                curr[j] = Math.min(take, ntake);    
            }
            prev = curr;
        }

        return prev[amount] >= (int)1e9 ? -1 : prev[amount];
    }
}