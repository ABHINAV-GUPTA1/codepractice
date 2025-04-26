class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (hi == 0) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[hi] > nums[hi-1]) {
            return hi;
        }
        lo++;
        hi--;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (nums[mid] > nums[mid-1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}