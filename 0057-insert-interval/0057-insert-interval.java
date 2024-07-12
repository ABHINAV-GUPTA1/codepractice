class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b)->(Integer.compare(a[0], b[0])));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}