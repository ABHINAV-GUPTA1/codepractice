class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[0] = -1;
        dp[1] = 1;
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        int n2, n3, n5;
        int val;
        for (int i = 2; i <= n; i++) {
            n2 = dp[i2] * 2;
            n3 = dp[i3] * 3;
            n5 = dp[i5] * 5;
            val = Math.min(Math.min(n2, n3), n5);

            if (val == n2) {
                i2++;
            }
            if (val == n3) {
                i3++;
            }
            if (val == n5) {
                i5++;
            }
            dp[i] = val;
        }

        return dp[n];
    }
}