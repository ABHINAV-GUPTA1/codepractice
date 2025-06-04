class Solution {
    public int cutRod(int[] price) {
        // return f(price.length, price);
        int n = price.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= i; j++) {
                ans = Math.max(ans, price[j - 1] + dp[i - j]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
    
    private int f(int i, int[] price) {
        if (i == 0) {
            return 0;
        }
        int ans = 0;
        for (int j = 1; j <= i; j++) {
            ans = Math.max(ans, price[j - 1] + f(i - j, price));
        }
        return ans;
    }
}