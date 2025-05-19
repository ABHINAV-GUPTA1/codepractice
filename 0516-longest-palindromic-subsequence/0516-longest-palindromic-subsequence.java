class Solution {
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(n - j)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[n];
    }

    public int longestPalindromeSubseq_method2(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(n - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public int longestPalindromeSubseq_method1(String s) {
        return f(s, s.length() - 1, s.length() - 1);
    }

    private int f(String s, int i1, int i2) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }
        int n = s.length();
        if (s.charAt(i1) == s.charAt(n - i2 - 1)) {
            return 1 + f(s, i1 - 1, i2 - 1);
        } else {
            return Math.max(f(s, i1 - 1, i2), f(s, i1, i2 - 1));
        }
    }
}