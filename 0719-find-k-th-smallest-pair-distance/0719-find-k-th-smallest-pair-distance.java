class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDiff = nums[n-1] - nums[0];
        int low = 0;
        int high = maxDiff;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, nums, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }    

        return low;
    }

    private boolean isPossible(int mid, int[] arr, int k) {
        int j = 1;
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] - arr[i] <= mid) {
                j++;
            }
            j--;
            sum += (j-i);
        }

        return sum >= k;
    }
}