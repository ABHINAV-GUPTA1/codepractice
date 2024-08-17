class Solution {
    int[][][][] dp;
    public int countPalindromes(String s) {
        dp = new int[s.length()+1][11][11][6];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    dp[i][j][k][5] = 1;
                }
            }
        }
        String str = s;

        // return (int)(dfs(0, 10, 10, 0, s)%mod);


        for (int strInd = s.length()-1; strInd >= 0; strInd--) {
            for (int first = 0; first < 10; first++) {
                for (int second = 0; second < 10; second++) {
                    for (int newStrInd = 4; newStrInd >= 0; newStrInd--) {
                        int nPick = dp[strInd+1][first][second][newStrInd]%mod;

                        int pick = 0;
                        if (newStrInd == 0) {
                            // pick = dfs(strInd+1, str.charAt(strInd)-'0', second, newStrInd+1, str)%mod;
                            pick = dp[strInd+1][str.charAt(strInd)-'0'][second][newStrInd+1]%mod;
                        } else if (newStrInd == 1) {
                            // pick = dfs(strInd+1, first, str.charAt(strInd)-'0', newStrInd+1, str)%mod;
                            pick = dp[strInd+1][first][str.charAt(strInd)-'0'][newStrInd+1]%mod;
                        } else if (newStrInd == 2) {
                            pick = dp[strInd+1][first][second][newStrInd+1]%mod;
                        } else if (newStrInd == 3) {
                            if (second == (str.charAt(strInd)-'0')) {
                                pick = dp[strInd+1][first][second][newStrInd+1]%mod;
                            }
                        } else if (newStrInd == 4) {
                            if (first == (str.charAt(strInd)-'0')) {
                                pick = dp[strInd+1][first][second][newStrInd+1]%mod;
                            }
                        } else if (newStrInd == 5) {
                            pick = 1;
                        }

                        dp[strInd][first][second][newStrInd] = (pick+nPick)%mod; 

                    }
                }
            }
        }
        // for (int i = 0; i <= s.length(); i++) {
        //     for (int j = 0; j < 10; j++) {
        //         for (int k = 0; k < 10; k++) {
        //             System.out.print(Arrays.toString(dp[i][j][k]) +" ");
        //         }
        //         System.out.print("\t");
        //     }
        //     System.out.print("\n");
        // }
        return dp[0][9][9][0];
    }
    private static int mod = 1000_000_007; 
    private int dfs (int strInd, int first, int second, int newStrInd, String str) {
        if (newStrInd == 5) {
            return  1; // 1 possible ans
        }
        if (strInd == str.length()) {
            return 0; // no answer for current 
        }
        if (dp[strInd][first][second][newStrInd] != 0) {
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