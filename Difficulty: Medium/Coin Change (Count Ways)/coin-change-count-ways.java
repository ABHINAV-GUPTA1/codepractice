class Solution {
    Integer[][] dp;
    public int count(int coins[], int sum) {
        dp = new Integer[coins.length + 1][sum + 1];
        int ans = f(coins, coins.length - 1, sum);
        return ans;
    }
    
    private int f(int[] arr, int idx, int target) {
        if (idx == 0) {
            if (target%arr[idx] == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        int ntake = f(arr, idx - 1, target);
        int take = 0;
        if (arr[idx] <= target) {
            take = f(arr, idx, target - arr[idx]);
        }
        
        return dp[idx][target] = take + ntake;
    }
}