class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int head = 0;
        int tail = 0;
        long sum = 0;
        int n = nums.length;
        for (; head < n; head++) {
            sum += nums[head];
            while (sum*(head-tail+1) >= k) {
                sum -= nums[tail++];
            }
            ans += (head - tail + 1);
        }    
        return ans;
    }
}