class Solution {
    int[] dp;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // dp = new int[nums.length+1];
        // Arrays.fill(dp, -1);
        // return f1(0, nums);
        // return f2(nums.length-1, nums);

        // dp[0] = 0;
        // dp[1] = nums[0];
        // for (int i = 2; i <= nums.length; i++) {
        //     dp[i] = Math.max(nums[i-1]+dp[i-2], dp[i-1]);
        // }

        int prev2 = 0;
        int prev1 = nums[0];
        int curr = 0;
        for (int i = 2; i <= nums.length; i++) {
            curr = Math.max(nums[i-1]+prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    int f2(int n, int[] arr) {
        if (n == 0) {
            return arr[n];
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = Math.max(arr[n] + f2(n-2, arr), f2(n-1, arr));
    }


    int f1(int n, int[] nums) {
        if (n >= nums.length) {
            return 0;
        }
        if (n == nums.length-1) {
            return nums[n];
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = Math.max(nums[n] + f1(n+2, nums), f1(n+1, nums));
    }
}