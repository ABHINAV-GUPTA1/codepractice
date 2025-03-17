class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums[0] ^ 0;
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
            ans ^= i;
        }    
        return ans^nums.length;
    }
}