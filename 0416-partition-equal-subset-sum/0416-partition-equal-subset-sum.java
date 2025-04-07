class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        
        sum = Arrays.stream(nums).sum();
        
        if (sum % 2 == 1) {
            return false;
        }
        
        sum /= 2;
        boolean dp[] = new boolean[sum+1];
        dp[0] =  true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                dp[j] = dp[j] | dp[j-nums[i-1]];
            }
        }
        return dp[sum];
    }
}