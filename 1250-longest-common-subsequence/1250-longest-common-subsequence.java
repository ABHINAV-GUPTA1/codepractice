class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        // dp = new int[text1.length()+1][text2.length()+1];
        // for (int i = 0; i < text1.length(); i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        int n = text2.length();
        int[] prev = new int[n+1];
        int[] curr;
        for (int i = 1; i <= text1.length(); i++) {
            curr = new int[n+1];
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    // dp[i][j] = 1 + dp[i-1][j-1];
                    curr[j] = 1 + prev[j-1];
                } else {
                    // dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[n];
        // return dp[text1.length()][text2.length()];
    }

    private int f(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + f(i-1, j-1, s1, s2);
        }

        return dp[i][j] = Math.max(f(i-1, j, s1, s2), f(i,j-1, s1, s2));
    }
}