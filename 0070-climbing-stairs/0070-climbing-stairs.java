class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        if (n < 2) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
    public int climbStairs_method1_2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int take_1 = dp[i-1];
            int take_2 = dp[i-2];
            dp[i] = take_1 + take_2;
        }
        return dp[n];
        // return f(n);
    }
    
    private int f(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        int take_1 = f(i-1);
        int take_2 = f(i-2);
        return take_1 + take_2;
    }
}