class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for (int idx = n - 1; idx >= 0; idx--) {
            if (s.charAt(idx) == '0') {
                dp[idx] = 0;
            } else {
                int ans = dp[idx + 1];
                if (idx + 1 < s.length()) {
                    if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
                        ans += dp[idx + 2];
                    }
                }
                dp[idx] = ans;
            }
        }

        return dp[0];
    }

    /**
        Method 1 : recursion
    
     */
    public int numDecodings_method1(String s) {
        return f(0, s);
    }

    int f(int idx, String s) {
        if (idx == s.length()) {
            return 1;
        }
        if (idx > s.length()) {
            return 0;
        }
        if (s.charAt(idx) == '0') {
            return 0;
        }

        int ans = f(idx + 1, s);
        if (idx + 1 < s.length()) {
            if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
                ans += f(idx + 2, s);
            }
        }

        return ans;
    }
}