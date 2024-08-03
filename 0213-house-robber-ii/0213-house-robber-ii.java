class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        } 
        return f(nums.length-1, 0, nums);
    }

    int f(int idx, int flag, int[] nums) {
        if (idx == 0) {
            return flag == 1 ? 0 : nums[idx];
        }
        if (idx < 0) {
            return 0;
        }
        if (dp[idx][flag] != -1) {
            return dp[idx][flag];
        }
        int ntake = f(idx-1, flag, nums);
        int take = nums[idx] + f(idx-2, idx == nums.length-1 ? 1 : flag, nums);

        return dp[idx][flag] = Math.max(take, ntake);
    }
}