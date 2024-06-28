class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n <= 3) {
            return stones[n-1];
        }
        int ans = 0;
        for (int i  = 0; i < n - 2; i++) {
            ans = Math.max(ans, stones[i+2] - stones[i]);
        }

        return ans;
    }
}