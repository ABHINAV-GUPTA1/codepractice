class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        Arrays.sort(nums);
        return f(target, nums);
    }

    int f(int target, int[] arr) {
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

        for (int i : arr) {
            if (target-i >= 0) {
                res += f(target-i, arr);
            }
        }
        return dp[target] = res;
    }
}