class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        // Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int res = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    int take = dp[i - nums[j]];
                    res += take;
                }
            }
            dp[i] = res;
        }
        return dp[target];
        // return f(nums, target, dp);
    }

    private int f(int[] arr, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int take = f(arr, target - arr[i], dp);
            res += take;
        }
        return dp[target] = res;
    }

    /**
        method 2
        comb(nums, target, 0);
     */
    private int comb_method2(int[] arr, int target, int idx) {
        if (target == 0) {
            return 1;
        }
        if (idx >= arr.length || target < 0) {
            return 0;
        }
        int take = comb_method2(arr, target - arr[idx], 0);
        int ntake = comb_method2(arr, target, idx + 1);
        return take + ntake;
    }

    /**
        method 1
        comb_method1(nums, target);
     */

    private int comb_method1(int[] arr, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int take = comb_method1(arr, target - arr[i]);
            res += take;
        }
        return res;
    }
}