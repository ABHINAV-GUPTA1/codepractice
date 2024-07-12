class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int ans = 1;
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int lastTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastTime) {
                lastTime = intervals[i][1];
                ans++;
            }
        }
        return intervals.length-ans;
    }
}