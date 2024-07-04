class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(coins.length-1, coins, amount);
    }

    int f(int idx, int[] coins, int amt) {
        if (idx == 0) {
            if (amt%coins[idx] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][amt] != -1) {
            return dp[idx][amt];
        }
        int ntake = f(idx-1, coins, amt);
        int take = 0;
        if (coins[idx] <= amt) {
            take = f(idx, coins, amt-coins[idx]);
        }
        return dp[idx][amt] = take+ntake;
    }
}