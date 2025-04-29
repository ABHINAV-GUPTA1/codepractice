class Solution {
    public int majorityElement(int[] nums) {
        int majorityCount = 1;
        int majorityElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                majorityCount++;
            } else if (majorityCount == 0) {
                majorityElement = nums[i];
                majorityCount = 1;
            } else {
                majorityCount--;
            }
        }

        return majorityElement;
    }
}