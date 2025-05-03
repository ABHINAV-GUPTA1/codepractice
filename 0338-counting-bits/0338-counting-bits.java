class Solution {
    public int[] countBits(int n) {
        n++;
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            ans[i] = (i&1) + ans[i/2];
        }
        return ans;
    }
}