class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int start = search(nums, target);
        
        if (start >= nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }

        return new int[] {start, search(nums, target+1) - 1};
    }

    private int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}