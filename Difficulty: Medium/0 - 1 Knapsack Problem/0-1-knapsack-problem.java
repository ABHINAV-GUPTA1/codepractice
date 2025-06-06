class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        // return f(W, val.length - 1, val, wt);
        int[][] dp = new int[W+1][val.length];
        for (int i = wt[0]; i <= W; i++) {
            dp[i][0] = val[0];
        }
        for (int w = 0; w <= W; w++) {
            for (int idx = 1; idx < val.length; idx++) {
                int ntake = dp[w][idx - 1];
                int take = Integer.MIN_VALUE;
                if (w >= wt[idx]) {
                    take =  val[idx] + dp[w - wt[idx]][idx - 1];
                }
                
                dp[w][idx] = Math.max(take, ntake);
            }
        }
        return dp[W][val.length - 1];
    }
    
    private static int f(int w, int idx, int[] val, int[] wt) {
        if (idx == 0) {
            return wt[0] == w ? val[0] : 0;
        }
        int ntake = f(w, idx - 1, val, wt);
        int take = Integer.MIN_VALUE;
        if (w >= wt[idx]) {
            take =  val[idx] + f(w - wt[idx], idx - 1, val, wt);
        }
        
        return Math.max(take, ntake);
    }
}
