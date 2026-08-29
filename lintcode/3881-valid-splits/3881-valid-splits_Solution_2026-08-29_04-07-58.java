public class Solution {
    /**
     * @param nums: An integer array
     * @return: Number of valid splits
     */
    public int countValidSplits(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = nums[0];
        right[len-1] = nums[len-1];
        for(int i = 1; i <  len;i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        for(int i = len - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }

        int count = 0;
        for(int i = 0; i < len - 1; i++) {
            if(left[i] <= right[i + 1]) {
                count++;
            }
        }
        return count;
    }
}