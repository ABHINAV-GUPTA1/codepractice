class Solution {
    int totalSum;
    public int maxSubarraySumCircular(int[] nums) {
        totalSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        totalSum = nums[0];
        int msum = nums[0]; // max temp sum
        int misum = nums[0]; // min temp sum
        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            msum = Math.max(nums[i]+msum, nums[i]);
            maxSum = Math.max(maxSum, msum);

            misum = Math.min(nums[i]+misum, nums[i]);
            minSum = Math.min(minSum, misum);

        }


        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }
        return maxSum;
    }
}