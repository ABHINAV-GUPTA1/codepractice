class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int head = 0;
        int tail = 0;
        int n = nums.length;
        int ans = n+2;
        int sum = 0;
        while (tail < n) {
            sum += nums[tail];
            while (sum >= target) {
                ans = Math.min(ans, tail - head + 1);
                sum -= nums[head++];
            }
            tail++;
        }
        return ans == n+2 ? 0 : ans;

    }
}