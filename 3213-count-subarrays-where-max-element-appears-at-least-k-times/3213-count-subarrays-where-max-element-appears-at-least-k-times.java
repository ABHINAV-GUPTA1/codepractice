class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int head = 0;
        int tail = 0;
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        long count = 0;
        for (; head < nums.length; head++) {
            count += (nums[head] == max ? 1 : 0);
            while (count >= k) {
                ans += (n-head);
                if (nums[tail++] == max) {
                    count--;
                }
            }
        }

        return ans;
    }
}