class Solution {
    /**
        Method 3: space optimized
     */
    public int numDecodings(String s) {
        int n = s.length();
        // int[] dp = new int[n + 1];
        // dp[n] = 1;
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (s.charAt(idx) == '0') {
                curr = 0;
            } else {
                int ans = prev1;
                if (idx + 1 < s.length()) {
                    if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
                        ans += prev2;
                    }
                }
                curr = ans;
            }
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    /**
        Method 2 : DP
     */
    public int numDecodings_method2(String s) {
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