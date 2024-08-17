class Solution {
    int[][][][] dp;
    public int countPalindromes(String s) {
        dp = new int[s.length()+1][10][10][5];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return dfs(0, 9, 9, 0, s);
    }
    private static int mod = 1000_000_007; 
    private int dfs (int strInd, int first, int second, int newStrInd, String str) {
        if (newStrInd == 5) {
            return  1; // 1 possible ans
        }
        if (strInd == str.length()) {
            return 0; // no answer for current 
        }
        if (dp[strInd][first][second][newStrInd] != -1) {
            return dp[strInd][first][second][newStrInd];
        }
        int nPick = dfs(strInd+1, first, second, newStrInd, str)%mod;

        int pick = 0;
        if (newStrInd == 0) {
            pick = dfs(strInd+1, str.charAt(strInd)-'0', second, newStrInd+1, str)%mod;
        } else if (newStrInd == 1) {
            pick = dfs(strInd+1, first, str.charAt(strInd)-'0', newStrInd+1, str)%mod;
        } else if (newStrInd == 2) {
            pick = dfs(strInd+1, first, second, newStrInd+1, str)%mod;
        } else if (newStrInd == 3) {
            if (second == (str.charAt(strInd)-'0')) {
                pick = dfs(strInd+1, first, second, newStrInd+1, str)%mod;
            }
        } else if (newStrInd == 4) {
            if (first == (str.charAt(strInd)-'0')) {
                pick = dfs(strInd+1, first, second, newStrInd+1, str)%mod;
            }
        }

        return dp[strInd][first][second][newStrInd] = (pick+nPick)%mod;    
    }
}