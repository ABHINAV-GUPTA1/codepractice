class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;

        for (int i = happiness.length - 1; i >= 0 && k-- > 0; i--) {
            int val = (happiness[i] - (happiness.length - i - 1));
            if (val > 0) {
                ans += val;
            }
        }

        return ans;
    }
}