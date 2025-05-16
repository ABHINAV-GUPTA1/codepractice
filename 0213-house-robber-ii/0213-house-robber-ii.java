class Solution {

    /**
        Method2 : DP
     */
    public int rob(int[] nums) {
        int[][] dp = new int[2][nums.length + 1];
        dp[0][1] = nums[0];

        for (int idx = 2; idx <= nums.length; idx++) {
            for (int flag = 0; flag < 2; flag++) {
                int take = nums[idx - 1] + dp[idx == nums.length ? 1 : flag][idx - 2];
                int ntake = dp[flag][idx - 1];
                dp[flag][idx] = Math.max(take, ntake);
            }
        }

        return dp[0][nums.length];
    }

    /**
        Method 1: recursion
     */
    public int rob_method1(int[] nums) {
        return f(nums.length - 1, 0, nums);
    }

    int f(int idx, int flag, int[] nums) {
        if (idx == 0 ) {
            return flag == 0 ? nums[idx] : 0;
        }

        if  (idx < 0) {
            return 0;
        }
        
        int take = nums[idx] + f(idx - 2, idx == nums.length - 1 ? 1 : flag, nums);
        int ntake = f(idx - 1, flag, nums);

        return Math.max(take, ntake);
    }
}