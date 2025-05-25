class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        int lastTime = intervals[0][0];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < lastTime) {
                count++;
            } else {
                lastTime = intervals[i][1];
            }
        }

        return count;
    }

    public int eraseOverlapIntervals_method1(int[][] intervals) {
        int count = 1;

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
        int lastTime = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastTime) {
                lastTime = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }
}