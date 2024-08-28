class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean isOne = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                isOne = true;
            }
            if (nums[i] > n || nums[i] < 1) {
                nums[i] = 1;
            }
        }
        if (!isOne) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1; 
            nums[idx] = -Math.abs(nums[idx]);
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i+1;
            }
        }

        return n+1;
    }
}