class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }
        int ans = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, threshold)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }    
        return ans;
    }

    private boolean isPossible(int[] arr, int m, int k) {
        int count = 0;
        double t = m;
        for (int i = 0; i < arr.length; i++) {
            count += Math.ceil(arr[i] / t);
        }
        return count <= k;
    }

}