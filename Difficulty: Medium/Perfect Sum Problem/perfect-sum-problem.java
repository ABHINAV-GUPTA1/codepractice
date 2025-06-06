class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // return f(nums, target, nums.length - 1);
        // int n = nums.length;
        // int[][] dp = new int[target + 1][n+1];
        // Arrays.fill(dp[0], 1);
        // for (int k = 1; k <= target; k++) {
        //     for (int idx = 1; idx <= n; idx++) {
        //         int ntake = dp[k][idx - 1];
        //         int take = 0;
        //         if (nums[idx - 1] <= k) {
        //             take = dp[k - nums[idx - 1]][idx - 1];
        //         }
                
        //         dp[k][idx] = take + ntake;
        //     }
        // }
        // return dp[target][n];
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
    
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
    
        return dp[target];
    }
    
    int f(int[] arr, int k, int idx) {
        if (k == 0) {
            return 1;
        }
        if (idx < 0) {
            return 0;
        }
        if (idx == 0) {
            return arr[idx] == k ? 1 : 0;
        }
        
        int ntake = f(arr, k, idx - 1);
        int take = 0;
        if (arr[idx] <= k) {
            take = f(arr, k - arr[idx], idx - 1);
        }
        
        return take + ntake;
    }
}