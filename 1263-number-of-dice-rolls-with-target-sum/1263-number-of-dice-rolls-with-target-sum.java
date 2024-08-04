class Solution {
    int mod = 1000_000_007;
    int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, n, k, target);
    }

    int f(int idx, int n, int maxDiceNumber, int target) {
        if (idx == n) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int ans = 0;
        for (int currDiceNumber = 1; currDiceNumber <= maxDiceNumber; currDiceNumber++) {
            if (target < currDiceNumber) {
                break;
            }
            ans = (ans + f(idx+1, n, maxDiceNumber, target-currDiceNumber)%mod)%mod;
        }

        return dp[idx][target] = ans%mod;
    }
}