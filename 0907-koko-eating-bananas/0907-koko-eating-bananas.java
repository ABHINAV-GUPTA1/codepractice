class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int mid, int[] arr, int h) {
        int count = 0;
        double tmp = mid;
        for (int i = 0; i < arr.length; i++) {
            count += Math.ceil(arr[i] / tmp);
        }
        return count <= h;
    }
}