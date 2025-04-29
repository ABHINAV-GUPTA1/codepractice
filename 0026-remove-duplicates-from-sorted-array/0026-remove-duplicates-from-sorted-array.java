class Solution {
    public int removeDuplicates(int[] nums) {
        int head = 0;
        int tail = 1;
        int length = nums.length;
        while (tail < length) {
            if (nums[head] != nums[tail]) {
                nums[++head] = nums[tail];
            }
            tail++;
        }
        return head + 1;
    }
}