class Solution {
    public int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        } 
        int diffBit = 0;
        for (int bit = 0; bit < 32; bit++) {
            int k = (1 << bit);
            if ((xor&k) != 0) {
                diffBit = k;
                break;
            }
        }
        //ans[0] represents groupA
        //ans[1] represents groupB
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&diffBit) != 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }

        return ans;
    }
}