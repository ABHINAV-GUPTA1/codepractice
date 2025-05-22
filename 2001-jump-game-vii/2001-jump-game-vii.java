class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = s.charAt(0) == '0';
        int reach = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump]) {
                reach++;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                reach--;
            }
            dp[i] = s.charAt(i) == '0' && reach > 0;
        } 

        return dp[n - 1];
    }
}