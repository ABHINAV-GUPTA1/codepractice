class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            max = Math.max(ranks[i], max);
        }

        long left = 1l;
        long right = max*(1l*cars*cars);
        long ans = -1l;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossible(ranks, mid, cars)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] arr, long mid, int cars) {
        long carsFixed = 0;
        for (int i = 0; i < arr.length; i++) {
            carsFixed += Math.sqrt(mid/arr[i]);
        }
        return carsFixed >= cars;
    } 
}