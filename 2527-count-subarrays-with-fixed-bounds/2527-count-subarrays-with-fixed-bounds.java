class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minIdx = -1;
        int maxIdx = -1;
        int culpritIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                minIdx = i;
            }
            if (nums[i] == maxK) {
                maxIdx = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                culpritIdx = i;
            }
            int smaller = Math.min(minIdx, maxIdx);
            int tempVal = smaller - culpritIdx;
            ans += tempVal > 0 ? tempVal : 0;
        }
        return ans;
    }
}