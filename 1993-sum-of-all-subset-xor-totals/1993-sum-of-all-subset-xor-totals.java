class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(0, 0, nums);
    }

    private int helper(int idx, int xor, int[] nums) {
        if (idx == nums.length) {
            return xor;
        }

        int inc = helper(idx+1, xor^nums[idx], nums);
        int exc = helper(idx+1, xor, nums);
        return inc+exc;
    }
}