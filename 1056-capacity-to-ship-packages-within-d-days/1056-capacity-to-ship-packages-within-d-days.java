class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] arr, int mid, int days) {
        int sum = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }

        return count <= days;
    }
}