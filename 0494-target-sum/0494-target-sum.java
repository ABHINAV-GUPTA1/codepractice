class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum-target < 0 || (sum-target)%2 == 1) {
            return 0;
        }
        int k = (sum-target)/2;
        dp = new int[nums.length][k+1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(nums.length-1, k, nums);
    }

    int f(int idx, int target, int[] nums) {
        
        if (idx == 0) {
            if (target == 0 && nums[idx] == 0) {
                return 2;
            }
            if (target == 0 || nums[idx] == target) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int ntake = f(idx-1, target, nums);
        int take = 0;
        if (nums[idx] <= target) {
            take = f(idx-1, target-nums[idx], nums);
        }
        return dp[idx][target] = take+ntake;
    }
}