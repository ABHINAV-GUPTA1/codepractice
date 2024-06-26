class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1002];
        int res = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 501;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                res = Math.max(res, dp[i][diff]);
            }
        }
        return res;
    }

    
}