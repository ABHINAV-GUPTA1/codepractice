class Solution {
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        if (stones[1] == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        dp = new Boolean[stones.length+1][2001];
        return f(0,0,map, stones);
    }

    boolean f(int idx, int jmp, Map<Integer, Integer> map, int[] stones) {
        if (idx == stones.length-1) {
            return true;
        }
        if (dp[idx][jmp] != null) {
            return dp[idx][jmp];
        }
        boolean check = false;
        for (int njmp = jmp-1; njmp <= jmp+1; njmp++) {
            if (njmp <= 0) {
                continue;
            }
            int k = stones[idx]+njmp;
            if (!map.containsKey(k)) {
                continue;
            }
            check |= f(map.get(k), njmp, map, stones);
        }
        return dp[idx][jmp] = check;
    }
}