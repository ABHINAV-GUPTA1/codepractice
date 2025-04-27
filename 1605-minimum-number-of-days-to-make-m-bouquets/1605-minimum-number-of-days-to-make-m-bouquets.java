class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m*k > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] arr, int days, int needed, int k) {
        int count = days >= arr[0] ? 1 : 0;
        int totalBouquets = 0;
        for (int i = 1; i < arr.length; i++) {
            if (days >= arr[i]) {
                count++;
            } else {
                totalBouquets += (count / k);
                count = 0;
            }
        }
        totalBouquets += (count / k);
        return totalBouquets >= needed;
    }
}