class Solution {
    public int minCost(int n, int i, int d, int c) {
        // code here
        int dp[] = new int[n + 1];
        dp[1] = i;
        for(int k = 2; k <= n; k++){

            int min = dp[k - 1] + i;
            if((k % 2) == 0) {
                min = Math.min(dp[k / 2] + c, min);
            }else{
               min = Math.min(min, Math.min(dp[k/2]+c+i, dp[k/2 +1]+c+d)); 
            }
            dp[k] = min;
        }
        return dp[n];
    }
}