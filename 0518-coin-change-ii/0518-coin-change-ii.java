class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(coins.length-1, amount, coins);
    }

    int f(int idx, int target, int[] arr) {
        if (idx == 0) {
            return target%arr[idx] == 0 ? 1 : 0;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int ntake = f(idx-1, target, arr);
        int take = 0;
        if (target-arr[idx] >= 0) {
            take = f(idx, target-arr[idx], arr);
        }

        return dp[idx][target] = take+ntake;
    }
}