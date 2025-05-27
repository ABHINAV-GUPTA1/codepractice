// User function Template for Java

class Solution {
    
    boolean[][] dp;
    public int minDifference(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        dp = new boolean[arr.length][sum + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        for (int idx = 1; idx < arr.length; idx++) {
            for (int k = 1; k <= sum; k++) {
                boolean ntake = dp[idx - 1][k];
                boolean take = false;
                if (arr[idx] <= k) {
                    take = dp[idx - 1][k - arr[idx]];
                }
                dp[idx][k] = take || ntake;
            }
        }
        
        int mini = (int)1e9;
        for (int i = 0; i <= sum/2; i++) {
            if (dp[arr.length - 1][i]) {
                mini = Math.min(mini, Math.abs(sum - i - i));
            }
        }
        
        return mini;
    }
    
    private boolean f(int[] arr, int idx, int k) {
        if (k == 0) {
            return dp[idx][k] = true;
        }
        if (idx == 0) {
            return dp[idx][k] = (arr[idx] == k);
        }
        // if (dp[idx][k] != null) {
        //     return dp[idx][k];
        // }
        
        boolean ntake = f(arr, idx - 1, k);
        boolean take = false;
        if (arr[idx] <= k) {
            take = f(arr, idx - 1, k - arr[idx]);
        }
        return dp[idx][k] = take || ntake;
    }
}
