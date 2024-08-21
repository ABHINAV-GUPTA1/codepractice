class Solution {
    int[][] dp;
    public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, n-1, s);
    }

    int f(int l, int r, String s) {
        if (l == r) {
            return 1;
        }

        if (l > r) {
            return 0;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        int i = l + 1;
        while (i <= r && s.charAt(l) == s.charAt(i)) {
            i++;
        }

        if (i == r+1) {
            return 1;
        }

        int m1 = 1 + f(i, r, s);

        // aba
        int m2 = Integer.MAX_VALUE;
        for (int j = i; j <= r; j++) {
            if (s.charAt(l) == s.charAt(j)) {
                m2 = Math.min(m2, f(i, j-1, s) + f(j, r, s));
            }
        }

        return dp[l][r] = Math.min(m1, m2);
    }
}