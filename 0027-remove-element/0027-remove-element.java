class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = 0;
        while (tail < nums.length) {
            if (nums[tail] != val) {
                nums[head++] = nums[tail];
            }
            tail++;
        }
        return head;
    }
}