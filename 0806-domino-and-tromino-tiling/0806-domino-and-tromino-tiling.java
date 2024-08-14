class Solution {
    int MOD = (int)1e9+7;
    public int numTilings(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 5;

        int a = 1;
        int b = 1;
        int c = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            // dp[i] = ((2*dp[i-1])%MOD + dp[i-3])%MOD;

            ans = ((2*c)%MOD + a)%MOD;
            a = b;
            b = c;
            c = ans;
        }
        return c;
    }
}