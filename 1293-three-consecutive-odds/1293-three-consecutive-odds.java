class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 1) {
                count++;
                ans = Math.max(ans, count);
            } else {
                count = 0;
            }
        }
        return ans >= 3;
    }
}