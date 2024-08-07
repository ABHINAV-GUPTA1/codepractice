class Solution {

    int[] dp;    
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }    
        dp = new int[n+1];
        /**
            Method 1 : memoizaiton
            Method 2 : bottom up
         */
        // return f(n);

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j-1]*dp[i-j]);
            }
        }
        return dp[n];

    }

    private int f(int x) {
        if (x <= 1) {
            return 1;
        }
        if (dp[x] != 0) {
            return dp[x];
        }
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            ans += f(i-1)*f(x-i);
        }

        return dp[x] = ans;
    }
}