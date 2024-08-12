class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int val;
        for (int i = 1; i < prices.length; i++) {
            val = prices[i] - prices[i-1];
            if (val > 0) {
                ans += val;
            }
        }

        return ans;
    }
}