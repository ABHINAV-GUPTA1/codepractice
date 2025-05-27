class Solution {
    
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int idx = 2; idx <= n; idx++) {
            int ans = 0;
            for (int i = 1; i <= idx; i++) {
                ans += dp[i-1] * dp[idx - i];
            }
            dp[idx] = ans;
        }   

        return dp[n];
        
    }

    public int numTrees_method2(int n) {
        return (int) (factorial(2 * n) / (factorial(n + 1) * factorial(n)) );
    }

    private long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
    Integer[] dp;
    public int numTrees_method1(int n) {
        dp = new Integer[n + 1];
        return f(n);
    }

    private int f(int n) {
        if (n < 2) {
            return 1;
        }
        if (dp[n] != null) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += f(i-1) * f(n - i);
        }
        return dp[n] = ans;
    }
}