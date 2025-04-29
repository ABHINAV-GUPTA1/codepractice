class Solution {
    public int removeDuplicates(int[] nums) {
        int head = 0;
        int tail = 1;
        int count = 1;
        while (tail < nums.length) {
            if (nums[head] != nums[tail]) {
                nums[++head] = nums[tail];
                count = 1;
            } else if (count < 2){
                count++;
                nums[++head] = nums[tail];
            } else {
                count++;
            }
            tail++;
        }
        return head + 1;
    }
}