class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int min = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(piles, mid, h)) {
                min = Math.min(min, mid);
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    private boolean isValid(int[] arr, int mid, int max) {
        long ans = 0;
        double t = mid;
        for (int i = 0; i < arr.length; i++) {
            ans += (long)Math.ceil(arr[i]/t);
        }
        return ans <= max;
    }
}