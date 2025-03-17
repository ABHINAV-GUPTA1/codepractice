class Solution {
    public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int oneIdx = 0;
        int twoIdx = nums.length-1;
        while (oneIdx <= twoIdx) {
            if (nums[oneIdx] == 0) {
                swap(nums, oneIdx, zeroIdx);
                zeroIdx++;
                oneIdx++;
            } else if (nums[oneIdx] == 1) {
                oneIdx++;
            } else {
                swap(nums, oneIdx, twoIdx);
                twoIdx--;
            }
        }
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }
}