class Solution {
    
    public boolean canReach(String s, int minJump, int maxJump) {
        int farthest = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int n = s.length();
        while (!q.isEmpty()) {
            int val = q.poll();
            int end = Math.min(val + maxJump + 1, n);
            for (int start = Math.max(val + minJump, farthest + 1); start < end; start++) {
                if (s.charAt(start) == '0') {
                    q.offer(start);
                    if (start == n - 1) {
                        return true;
                    }
                }
            }
            farthest = val + maxJump;
        }

        return false;
    }

    public boolean canReach_method1(String s, int minJump, int maxJump) {
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