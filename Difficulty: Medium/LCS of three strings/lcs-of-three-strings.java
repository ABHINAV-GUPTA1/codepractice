class Solution {
    int lcsOf3(String A, String B, String C) {
        int n1 = A.length();
        int n2 = B.length();
        int n3 = C.length();
        int dp[][][] = new int[n1+1][n2+1][n3+1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    } else if (A.charAt(i-1) == B.charAt(j-1) && A.charAt(i-1) == C.charAt(k-1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
}