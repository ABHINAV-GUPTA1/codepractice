class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return -1;
        } 

        int low = nums[0], high = nums[0];
        for (int i = 1; i < n; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
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
        int count = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                sum = arr[i];
                count++;
            }
        }
        return count <= k;
    }
}