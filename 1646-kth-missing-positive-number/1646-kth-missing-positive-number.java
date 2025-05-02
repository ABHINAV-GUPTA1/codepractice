class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high + k + 1; // low + k
    }
}
/**
    more = k - mising -- 1
    missing = arr[high] - (high + 1) --- 2
    
    ans = arr[high] + more
    => ans = arr[high] + (k - missing)
    => ans = arr[high] + (k - (arr[high] - (high + 1)))
    => ans = arr[high] + k - arr[high] + high + 1
    => ans = k + (high + 1)
        or 
    => ans = k + low
 */