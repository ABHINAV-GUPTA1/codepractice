class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 4; i++) {
            ans = Math.min(ans, Math.abs(nums[n-i] - nums[4-i]));
        }

        return ans;
    }
}