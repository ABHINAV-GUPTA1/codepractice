class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i : weights) {
            low = Math.max(low, i);
            high += i;
        }
        int ans = days;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, weights, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int val, int[] arr, int days) {
        int sum = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (sum + arr[i] <= val) {
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }
        return count <= days;
    }
}