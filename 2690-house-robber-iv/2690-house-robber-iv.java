class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isPossible(int[] arr, int mid, int k) {
        int idx = 0;
        while (idx < arr.length) {
            if (arr[idx] <= mid) {
                idx += 2;
                k--;
            } else {
                idx++;
            }
            if (k == 0) {
                return true;
            }
        }

        return k <= 0;
    }
}