class Solution {
    public int maxProduct(int[] nums) {
        double min = nums[0];
        double max = nums[0];
        double ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            double t = Math.max(nums[i], Math.max(nums[i]*max, nums[i]*min));
            min = Math.min(nums[i], Math.min(nums[i]*max, nums[i]*min));
            max = t;
            ans = Math.max(ans, max);
        }
        return (int)ans;
    }
}