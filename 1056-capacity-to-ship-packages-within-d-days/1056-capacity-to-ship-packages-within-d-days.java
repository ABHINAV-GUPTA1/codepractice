class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = weights[0];
        for (int i = 1; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high = high + weights[i];
        }

        int mid;
        int ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isPossible(mid, weights) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    int isPossible(int cap, int weights[]) {
        int sum = weights[0];
        int day = 1;
        for (int i = 1; i < weights.length; i++) {
            if (sum+weights[i] > cap) {
                sum = weights[i];
                day++;
            } else {
                sum += weights[i];
            }
        }
        return day;
    }
}