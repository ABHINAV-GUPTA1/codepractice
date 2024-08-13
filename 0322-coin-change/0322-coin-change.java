class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(coins.length-1, amount, coins);
        return ans == (int)1e9 ? -1 : ans;
    }
    int f(int idx, int target, int[] arr) {
        if (idx == 0) {
            return target%arr[idx] == 0 ? target/arr[idx] : (int)1e9;
        }
        if (target < 0) {
            return (int)1e9;
        }
        if (target == 0) {
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int ntake = f(idx-1, target, arr);
        int take = (int)1e9;
        if (target-arr[idx] >= 0) {
            take = 1 + f(idx, target-arr[idx], arr);
        }

        return dp[idx][target] = Math.min(take, ntake);
    }
}