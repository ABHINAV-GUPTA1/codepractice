class Solution {

    /**
    
        Space optimized
     */
    public int rob(int[] nums) {
        int[] prev2 = new int[2];
        int[] prev1 = new int[2];
        prev1[0] = nums[0];
        int[] curr = new int[2];
        for (int idx = 2; idx <= nums.length; idx++) {
            for (int flag = 0; flag < 2; flag++) {
                int take = nums[idx - 1] + prev2[idx == nums.length ? 1 : flag];
                int ntake = prev1[flag];
                curr[flag] = Math.max(take, ntake);
            }
            // prev2 = prev1;
            prev2 = Arrays.copyOf(prev1, prev1.length);

            // prev1 = curr;
            prev1 = Arrays.copyOf(curr, curr.length);
        }

        return prev1[0];
    } 

    /**
        Method2 : DP
     */
    public int rob_method2(int[] nums) {
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