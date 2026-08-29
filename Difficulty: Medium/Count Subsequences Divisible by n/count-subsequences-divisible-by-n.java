class Solution {
    public int countSubsequences(String s, int n) {
        // code here
        final int MOD = 1_000_000_007;
        long[] dp = new long[n];

        for (char c : s.toCharArray()) {
            int d = c - '0';
            long[] newdp = dp.clone(); 

            for (int r = 0; r < n; r++) {
                if (dp[r] == 0) continue;
                int nr = (int) ((r * 10L + d) % n);
                newdp[nr] = (newdp[nr] + dp[r]) % MOD;
            }

            int dr = d % n;
            newdp[dr] = (newdp[dr] + 1) % MOD;

            dp = newdp;
        }

        return (int) dp[0];
    }
}