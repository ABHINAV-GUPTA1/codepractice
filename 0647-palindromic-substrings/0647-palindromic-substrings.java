class Solution {
    private int[][] dp;
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        /**
            Method 1 :  check each and every substring of s whether palindrome or not
            Method 2 : memoize the check method as we have repeating subproblems for i,j

         
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (check(s, i, j)) {
                    count++;
                }
            }
        }
        return count;

        */

        /**
            Method 3 : dp tabulation bottom up
         
            i_____j
            [--L--]
            => j = i + L - 1;
            
            3 cases
            1 length substring [_] => always palindrome
            2 length substring [ij] => i.e. s[i] == s[j] then palindrome
            > 2 length substring [i______j] => ((s[i] == s[j]) && dp[i+1][j-1]) then palindrome
       
        boolean dp[][] = new boolean[n][n];
        
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i+l-1 < n; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (i+1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]);
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
        */

        /**
            Method 4: odd and even palindromes
         */
        for (int i = 0; i < n; i++) {
            count += check(s, i, i, n);
            count += check(s, i, i+1, n);
        }

        return count;
    }

    private int check(String s, int i, int j, int n) {
        int count = 0;
        int x = i;
        int y = j;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }

    /** 
        Method 1 and 2
    
    private boolean check(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = check(s, i+1, j-1) ? 1 : -1;
            return dp[i][j] == 1;
        }
        dp[i][j] = -1;
        return false;
    }

    */
}