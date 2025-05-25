class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}