class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp = new int[2][nums.length+2];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return f(0, 0, nums);
    }

    private int f(int n, int flag, int[] arr) {
        if (n == arr.length-1) {
            return flag == 0 ? arr[n] : 0;
        }
        if (n >= arr.length) {
            return 0;
        }
        if (dp[flag][n] != -1) {
            return dp[flag][n];
        }

        return dp[flag][n] = Math.max(arr[n]+f(n+2, n == 0 ? 1 : flag, arr), f(n+1, flag, arr));
    }
}