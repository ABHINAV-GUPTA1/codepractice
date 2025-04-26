class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        Arrays.sort(piles);
        int high = 1;
        int ans = 1;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isValid(int[] arr, int mid, int h) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.ceil((double)arr[i] / mid);
        }
        return count <= h;
    }
}