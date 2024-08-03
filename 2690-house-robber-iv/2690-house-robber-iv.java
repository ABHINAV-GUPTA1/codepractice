class Solution {
    int MAX = (int)1e9+1;
    public int minCapability(int[] nums, int k) {
        int low = 1;
        int high = MAX;
        int ans = MAX;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] arr, int mid, int k) {
        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (arr[i] <= mid) {
                k--;
                i+=2;
            } else {
                i++;
            }
            if (k == 0) {
                return true;
            }
        }
        return false;
    }
}