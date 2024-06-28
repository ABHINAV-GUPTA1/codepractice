class Solution {
    Boolean[][] dp;
    Map<Integer, Integer> map;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new Boolean[n][2001];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        return solve(0, 0, stones);
    }

    boolean solve(int curr, int prevJmp, int[] arr) {
        if (curr == arr.length - 1) {
            return true;
        }
        if (dp[curr][prevJmp] != null) {
            return dp[curr][prevJmp];
        }
        boolean res = false;
        int nwJmp;
        for (int nxt = prevJmp-1; nxt <= prevJmp + 1; nxt++) {
            if (nxt > 0) {
                nwJmp = arr[curr] + nxt;
                if (map.containsKey(nwJmp)) {
                    res = res || solve(map.get(nwJmp), nxt, arr);
                }
            }
        }

        return dp[curr][prevJmp] = res;
    }
}