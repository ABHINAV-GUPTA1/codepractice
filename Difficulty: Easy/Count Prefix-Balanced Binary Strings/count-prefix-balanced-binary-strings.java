class Solution {
    int mod = 1000000007;
    
    public int solve(int one, int zero, int[][] dp) {
    
       if (one == 0 && zero == 0)
           return 1;
    
       if (dp[one][zero] != -1)
           return dp[one][zero];
    
       long ans = 0;
    
    
       if (one > 0) {
           ans += solve(one - 1, zero, dp);
       }
    
    
       if (zero > one) {
           ans += solve(one, zero - 1, dp);
       }
    
       return dp[one][zero] = (int)(ans % mod);
    }
    
    
    public int prefixStrings(int n) {
        // code here
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n, n, dp);
    }
}