class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a,b)-> a[0]==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        // res list
        List<int[]> list = new ArrayList<>();
        int[] tmp; // tmp variable
        for (int i = 0; i < intervals.length; i++) {
            // check if first element then insert else
            // check last added element end time and current interval start time
            // if curr interval start time > last added interval end time then add it else
            // compare the endtime for both and update it in list last element  
            if (list.size() == 0 || intervals[i][0] > list.get(list.size()-1)[1]) {
                list.add(intervals[i]);
            } else {
                tmp = list.get(list.size()-1);
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}