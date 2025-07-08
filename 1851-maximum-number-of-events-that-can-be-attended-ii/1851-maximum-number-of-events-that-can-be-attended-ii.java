class Solution {
    
    Integer[][] dp;

    public int maxValue(int[][] events, int k) {
        dp = new Integer[events.length][k + 1];
        Arrays.sort(events, (a, b)->a[0]-b[0]);
        return solve(events, 0, k);    
    }

    private int solve(int[][] arr, int idx, int k) {
        if (idx >= arr.length || k == 0) {
            return 0;
        }
        if (dp[idx][k] != null) {
            return dp[idx][k];
        }
        int ntake = solve(arr, idx + 1, k);
        // int take = arr[idx][2];
        // for (int j = idx + 1; j < arr.length; j++) {
        //     if (arr[j][0] > arr[idx][1]) {
        //         take += solve(arr, j, k - 1);
        //         break;
        //     }
        // }

        int takeIdx = binarySearchUpperBound(arr, idx + 1, arr[idx][1] + 1);
        int take = arr[idx][2] + solve(arr, takeIdx, k - 1);
        return dp[idx][k] = Math.max(take, ntake);

    }

    private int binarySearchUpperBound(int[][] arr, int idx, int val) {
        int low = idx;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][0] >= val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}