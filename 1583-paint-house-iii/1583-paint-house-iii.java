class Solution {
    private static int MAX = 10000001;
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new int[m][n+1][target+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = f(0, 0, 0, houses, cost, m, n, target);
        return ans < MAX ? ans : -1;        
    }

    private int f(int idx, int prevNbr, int nbrCount, int[] houses, int[][] cost, int m, int n, int target) {
        if (idx == m) {
            return nbrCount == target ? 0 : MAX;
        }
        if (nbrCount > target) {
            return MAX;
        }

        if (dp[idx][prevNbr][nbrCount] != -1) {
            return dp[idx][prevNbr][nbrCount];
        }

        if (houses[idx] == 0) { // not colored
            int min = MAX;
            for (int c = 1; c <= n; c++) {
                int newNbrCount = nbrCount;
                if (prevNbr != c) {
                    newNbrCount += 1;
                }
                min = Math.min(min, cost[idx][c-1] + f(idx+1, c, newNbrCount, houses, cost, m, n, target));
            }
            return dp[idx][prevNbr][nbrCount] = min;
        } else {
            int newNbrCount = nbrCount;
            if (prevNbr != houses[idx]) {
                newNbrCount += 1;
            }
            return dp[idx][prevNbr][nbrCount] = f(idx+1, houses[idx], newNbrCount, houses, cost, m, n, target);
        }
    }
}