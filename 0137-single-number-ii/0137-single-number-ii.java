class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int k = (1 << bit);
            int countZero = 0;
            int countOne = 0;
            for (int num : nums) {
                if ((num&k) == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            if ((countOne%3) == 1) {
                ans = (ans | k);
            }
        }

        return ans;
    }
}