class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int mini = -1;
        int maxi = -1;
        int ci = -1;
        int temp = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                ci = i;
            }
            if (nums[i] == minK) {
                mini = i;
            }
            if (nums[i] == maxK) {
                maxi = i;
            }
            temp = (Math.min(mini, maxi)) - ci;
            ans += (temp<=0 ? 0 : temp); 
        }
        return ans;
    }
}