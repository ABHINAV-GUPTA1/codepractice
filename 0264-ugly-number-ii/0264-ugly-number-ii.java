class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        int nugly = 1;
        int nu2 = 2;
        int nu3 = 3;
        int nu5 = 5;
        dp[0] =1;
        int ni2 = 0, ni3=0, ni5 = 0;
        for (int i = 1; i < n; i++) {
            nugly = Math.min(nu2, Math.min(nu3, nu5));
            dp[i] = nugly;
            if (nugly == nu2) {
                ni2++;
                nu2 = dp[ni2]*2;
            }
            if (nugly == nu3) {
                ni3++;
                nu3 = dp[ni3]*3;
            }
            if (nugly == nu5) {
                ni5++;
                nu5 = dp[ni5]*5;
            }

        }
        return nugly;
    }
}