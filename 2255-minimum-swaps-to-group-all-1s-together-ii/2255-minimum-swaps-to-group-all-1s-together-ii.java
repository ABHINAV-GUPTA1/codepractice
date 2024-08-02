class Solution {
    public int minSwaps(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count1++;
            }
        }
        int windowSize = count1;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] == 0) {
                count0++;
            }
        }
        int ans = count0; // min swaps
        for (int i = windowSize; i < n+windowSize; i++) {
            if (nums[i%n] == 0) {
                count0++;
            }
            if (nums[i-windowSize] == 0) {
                count0--;
            }
            ans = Math.min(ans, count0);
        }

        return ans;
    }
}