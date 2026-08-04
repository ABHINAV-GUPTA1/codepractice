class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int i1 = 0, i2 = 0, i3 = 0;
        int i = n - 1;
        while (i >= 0) {
            int ans = Integer.MIN_VALUE;
            ans = stoneValue[i] - i1;
            if (i+2 <= n) {
                ans = Math.max(ans, stoneValue[i]+stoneValue[i+1]-i2);
            }
            if (i+3 <= n) {
                ans = Math.max(ans, stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-i3);
            }
            i3 = i2;
            i2 = i1;
            i1 = ans;
            i--;
        }
        return (i1 > 0 ? "Alice" : (i1 < 0 ? "Bob" : "Tie"));
    }
}