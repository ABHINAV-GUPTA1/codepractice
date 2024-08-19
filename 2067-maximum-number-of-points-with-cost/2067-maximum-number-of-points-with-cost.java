class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prev[i] = points[0][i];
            ans = Math.max(ans, prev[i]);
        }
        long[] left;
        long[] right;
        
        for (int idx = 1; idx < m; idx++) {
            left = new long[n];
            right = new long[n];
            left[0] = prev[0];
            for (int i = 1; i < n; i++) {
                left[i] = Math.max(left[i-1]-1, prev[i]);
            }
            right[n-1] = prev[n-1];
            for (int i = n-2; i >= 0; i--) {
                right[i] = Math.max(right[i+1]-1, prev[i]);
            }

            for (int i = 0; i < n; i++) {
                prev[i] = points[idx][i] + Math.max(left[i], right[i]);
                ans = Math.max(ans, prev[i]);
            }
        }
        return ans;
    }
}