class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2) {
            return 0;
        }
        int head = 0, tail = 0, ans = 0, prod = 1;
        while (head < nums.length) {
            prod *= nums[head];
            while (prod >= k) {
                prod /= nums[tail++];
            }
            ans += (head - tail + 1);
            head++;
        }
        return ans;
    }
}