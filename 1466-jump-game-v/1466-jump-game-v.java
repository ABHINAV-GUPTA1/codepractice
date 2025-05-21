class Solution {
    Integer[] dp;
    public int maxJumps(int[] arr, int d) {
        dp = new Integer[arr.length];
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, f(arr, i, d));
        }    

        return ans;
    }

    private int f(int[] arr, int idx, int d) {
        if (dp[idx] != null) {
            return dp[idx];
        }
        int ans = 1;
        for (int i = idx - 1; i >= Math.max(idx - d, 0) && arr[idx] > arr[i]; i--) {
            ans = Math.max(ans, 1 + f(arr, i, d));
        }
        for (int i = idx + 1; i <= Math.min(idx + d, arr.length - 1) && arr[idx] > arr[i]; i++) {
            ans = Math.max(ans, 1 + f(arr, i, d));
        }
        return dp[idx] = ans;
    }
}