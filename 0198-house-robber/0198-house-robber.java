class Solution {
    int[] dp;
    
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        dp[0] = nums[0];
        for (int idx = 1; idx < n; idx++) {
            int take = nums[idx]; 
            if (idx > 1) {
                take += dp[idx-2];
            }
            int ntake = dp[idx-1];
            dp[idx] = Math.max(take, ntake);
        }

        return dp[n-1];
    }
    
    public int rob1(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n-1, nums);
    }
    int f(int idx, int[] arr) {
        if (idx == 0) {
            return arr[idx];
        }
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int take = arr[idx] + f(idx-2, arr);
        int ntake = f(idx-1, arr);

        return dp[idx] = Math.max(take, ntake);
    }
}