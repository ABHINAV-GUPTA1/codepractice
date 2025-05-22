class Solution {
    
    public boolean canReach(String s, int minJump, int maxJump) {
        int farthest = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int n = s.length();
        while (!q.isEmpty()) {
            int qval = q.poll();
            int start = Math.max(qval + minJump, farthest + 1);
            int end = Math.min(qval + maxJump + 1, n);
            farthest = qval + maxJump;
            for (; start < end; start++) {
                if (s.charAt(start) == '0') {
                    q.offer(start);
                    if (start == n - 1) {
                        return true;
                    }
                }
            } 
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