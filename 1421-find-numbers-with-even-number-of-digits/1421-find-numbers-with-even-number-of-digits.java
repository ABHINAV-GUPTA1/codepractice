class Solution {
    public int findNumbers(int[] nums) {
        
        int count = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if ((nums[i] > 9 && nums[i] < 100) 
                || (nums[i] > 999 && nums[i] < 10000)
                || nums[i] == 100000) {
                    count++;
            }
        }

        return count;
    }
}