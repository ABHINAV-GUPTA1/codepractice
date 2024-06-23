class Solution {

    public int lengthOfLIS(int[] nums) { 
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1+dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthOfLIS1(int[] nums) {
        // return f(0, -1, nums);
        int n = nums.length;
        // int dp[][] = new int[n+1][n+1];
        int[] curr = new int[n+1];
        int[] next = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {
                // int len = dp[i+1][j+1];
                int len = next[j+1];
                if (j == -1 || nums[i] > nums[j]) {
                    // len = Math.max(len, 1+dp[i+1][i+1]);
                    len = Math.max(len, 1+next[i+1]);
                }
                // dp[i][j+1] = len;
                curr[j+1] = len;
            }
            next = curr;
        }

        // return dp[0][-1+1];
        return curr[-1+1];
    }

    int f(int idx, int prevIdx, int[] arr) {
        if (idx == arr.length) {
            return 0;
        }
        int len = f(idx+1, prevIdx, arr);
        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            len = Math.max(len, 1+f(idx+1, idx, arr));
        }
        return len;
    }
}